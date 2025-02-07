import { defineStore } from "pinia";
import axiosInstance from "../axios/asios";

export const useUserStore = defineStore("user", {
  state: () => ({
    userInfo: JSON.parse(localStorage.getItem("userInfo")) || null, // Lấy thông tin user từ localStorage nếu có
  }),
  actions: {
    // Hàm đăng ký và tự động đăng nhập
    async registerAndLogin(userInfo) {
      try {
        console.log("Bắt đầu gửi yêu cầu đăng ký...");
        // Gửi yêu cầu đăng ký
        const registerResponse = await axiosInstance.post(
          "/store/users",
          userInfo
        );
        localStorage.setItem("userInfo", JSON.stringify(userInfo));
        if (registerResponse.data) {
          // Đăng ký thành công, tiếp tục thực hiện đăng nhập
          console.log("Đăng ký thành công, thực hiện đăng nhập...");
          const loginResponse = await axiosInstance.post("/store/auth/token", {
            email: userInfo.email,
            password: userInfo.password,
          });
          console.log("loginResponse", loginResponse);
          // Kiểm tra xem login có trả về token hay không
          if (loginResponse.data && loginResponse.data.result.token) {
            console.log("Token nhận được: ", loginResponse.data.result.token);

            localStorage.setItem("token", loginResponse.data.result.token);

            // Lấy thông tin người dùng sau khi đăng nhập thành công
            this.fetchUserInfo();
            return true;
          } else {
            console.error("Không có token trả về khi đăng nhập");
            throw new Error("Không có token trả về khi đăng nhập");
          }
        } else {
          throw new Error("Đăng ký không thành công");
        }
      } catch (error) {
        console.error("Lỗi khi đăng ký và đăng nhập:", error);
        return false; // Trả về false nếu có lỗi
      }
    },

    // Hàm lấy thông tin người dùng
    async fetchUserInfo() {
      try {
        const token = localStorage.getItem("token");
        console.log("Lấy token từ localStorage: ", token);

        if (token) {
          const response = await axiosInstance.get("/store/users/myInfo", {
            headers: {
              Authorization: `Bearer ${token}`,
            },
          });
          console.log("response khi lấy thông tin người dùng:", response);

          if (response.data && response.data.result) {
            this.userInfo = response.data.result;
            console.log("Thông tin người dùng nhận được: ", this.userInfo);
            localStorage.setItem("userInfo", JSON.stringify(this.userInfo)); // Lưu thông tin vào localStorage
          } else {
            console.error("Không nhận được thông tin người dùng");
          }
        } else {
          console.log("Không có token trong localStorage");
          this.userInfo = null;
        }
      } catch (error) {
        console.error("Lỗi khi lấy thông tin user:", error);
        this.userInfo = null;
      }
    },

    // Hàm đăng xuất
    logout() {
      console.log("Đăng xuất...");
      this.userInfo = null;
      localStorage.removeItem("token");
      localStorage.removeItem("userInfo");
    },
  },
});
