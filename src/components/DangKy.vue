<template>
  <div>
    <Header></Header>

    <div class="container-default-DK">
      <article>
        <h1>Tạo tài khoản</h1>
        <h2>____</h2>
      </article>
      <aside>
        <div class="form-container">
          <form @submit.prevent="handleRegister">
            <div class="form-group">
              <input
                type="text"
                id="ho"
                name="ho"
                placeholder="Họ"
                v-model="user.firstName"
              />
            </div>
            <div class="form-group">
              <input
                type="text"
                id="ten"
                name="ten"
                placeholder="Tên"
                v-model="user.lastName"
              />
            </div>
            <!-- <div class="form-group">
              <label
                ><input
                  type="radio"
                  name="gender"
                  value="nu"
                  v-model="user.gender"
                />
                Nữ
                <input
                  type="radio"
                  name="gender"
                  value="nam"
                  v-model="user.gender"
                />
                Nam</label
              >
              <label></label>
            </div> -->
            <div class="form-group">
              <input type="date" id="dob" name="dob" v-model="user.birthday" />
            </div>
            <div class="form-group">
              <input
                type="email"
                id="email"
                name="email"
                placeholder="Email"
                v-model="user.email"
              />
            </div>
            <div class="form-group">
              <input
                type="password"
                id="password"
                name="password"
                placeholder="Mật khẩu"
                v-model="user.password"
              />
            </div>
            <!-- Các phần input khác -->

            <!-- Phần ghi chú -->
            <p class="note">
              This site is protected by reCAPTCHA and the Google
              <a href="https://policies.google.com/privacy" target="_blank"
                >Privacy Policy</a
              >
              and
              <a href="https://policies.google.com/terms" target="_blank"
                >Terms of Service</a
              >
              apply.
            </p>

            <!-- Nút Đăng ký -->
            <button type="submit" class="submit-btn">ĐĂNG KÝ</button>

            <!-- Link quay lại -->
            <router-link to="/"><a class="back-link"
              ><strong style="font-size: 14px; margin-right: 10px">← </strong
              >Quay lại trang chủ</a> </router-link>
            >
          </form>
        </div>
      </aside>
    </div>
    <footer>
     <Footer></Footer>
    </footer>
  </div>
</template>

<script setup>
import Footer from "./menu-link/Footer.vue";
import Header from "./menu-link/Header.vue";
import { useUserStore } from "../stores/userStore";
import { ref } from "vue";
import { useRouter } from "vue-router"; // Thêm import này


const router = useRouter(); // Khai báo router
const userStore = useUserStore();
const user = ref({
  email: "",
  password: "",
  confirmPassword: "", // Thêm trường xác nhận mật khẩu
  firstName: "",
  lastName: "",
  birthday: "",
});

const handleRegister = async () => {
  if (
    !user.value.email ||
    !user.value.password ||
    !user.value.firstName ||
    !user.value.lastName ||
    !user.value.birthday
  ) {
    alert("Vui lòng nhập đầy đủ thông tin!");
    return;
  }

  try {
    // Đảm bảo `await` được sử dụng để đợi kết quả của `registerAndLogin`
    const success = await userStore.registerAndLogin({
      email: user.value.email,
      password: user.value.password,
      firstName: user.value.firstName,
      lastName: user.value.lastName,
      birthday: new Date(user.value.birthday).toISOString().split("T")[0],
    });
    
    if (success) {
      alert("Đăng ký và đăng nhập thành công");
      router.push("/"); // Chuyển hướng về trang chủ
    } else {
      alert("Đăng ký hoặc đăng nhập thất bại");
    }
  } catch (error) {
    alert("Đã có lỗi xảy ra");
    console.error("Lỗi khi đăng ký:", error);
  }
};
</script>
<style></style>
