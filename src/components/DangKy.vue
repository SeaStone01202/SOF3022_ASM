<template>
  <div>
    <header>
      <div class="dongdau">
        <p>
          Miễn phí vận chuyển với đơn hàng trên 500K. Hàng pre-order còn được
          giảm thêm 5%.
        </p>
      </div>
      <div class="container">
        <div class="container1">
          <a href="/">
            <div class="swe"><img src="../assets/img/logo.webp" alt="" /></div>
          </a>
          <div class="seach">
            <input type="search" placeholder="Tìm kiếm sản phẩm..." />
            <button>
              <i
                class="fa-solid fa-magnifying-glass"
                style="color: #ffffff"
              ></i>
            </button>
          </div>
          <div class="login">
            <UserDropMenu></UserDropMenu>
          </div>
          <div class="cart">
            <i class="fa-solid fa-bag-shopping fa-xl" style="padding: 10px"></i>
            <p><a href="detail.html">giỏ hàng</a></p>
          </div>
        </div>
      </div>
      <Menu></Menu>
    </header>

    <div class="container-default">
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
                v-model="user.lastName"
              />
            </div>
            <div class="form-group">
              <input
                type="text"
                id="ten"
                name="ten"
                placeholder="Tên"
                v-model="user.firstName"
              />
            </div>
            <div class="form-group">
              <label
                ><input type="radio" name="gender" v-model="user.gender" />
                Nữ
                <input type="radio" name="gender" v-model="user.gender" />
                Nam</label
              >
              <label></label>
            </div>
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
            <a href="/" class="back-link"
              ><strong style="font-size: 14px; margin-right: 10px">← </strong
              >Quay lại trang chủ</a
            >
          </form>
        </div>
      </aside>
    </div>
    <footer>
      <div class="footer-content">
        <div class="newsletter">
          <h4>Nhận khuyến mãi</h4>
          <form>
            <input type="email" placeholder="Nhập email của bạn" />
            <button type="submit">
              <i class="fa fa-envelope"></i>
            </button>
          </form>
        </div>
        <div class="footer-sections">
          <div class="about-us">
            <h5>ABOUT US</h5>
            <p>
              Được thành lập vào cuối năm 2016 trong bối cảnh thời trang
              streetstyle dẫn nhẹn nhóm vào thị trường Việt Nam. Sau 6 năm phát
              triển, SWE - Street Wear Eazy với slogan Young kids with a
              mission™ đã chiếm được tình cảm của hầu hết các bạn trẻ yêu mến
              thời trang đường phố trên khắp cả nước.
            </p>
          </div>
          <div class="policy">
            <h5>CHÍNH SÁCH</h5>
            <ul>
              <li>Chính sách bảo mật</li>
              <li>Hướng dẫn mua hàng</li>
              <li>Phương thức thanh toán</li>
              <li>Chính sách giao nhận - vận chuyển</li>
              <li>Chính sách đổi và bảo hành sản phẩm</li>
            </ul>
          </div>
          <div class="store-info">
            <h5>HỆ THỐNG CỬA HÀNG SWE</h5>
            <ul>
              <li>Store 1: 44A Trần Quang Diệu, Quận 3</li>
              <li>Store 2: TNP Lý Tự Trọng, Quận 1</li>
              <li>Store 3: TNP Lê Lai, Quận 1</li>
              <li>
                Đại lý phân phối chính hãng: SN 84, Tổ 9, Hoàng Công Chất, P.
                Mường Thanh, TP Điện Biên
              </li>
            </ul>
            <div class="lienhe">
              <p>0357 420 420</p>
              <p>streetweareazy@gmail.com</p>
            </div>
          </div>
          <div class="social">
            <h5>FANPAGE</h5>
            <img
              src="../assets/img/z5992517442123_37d90b0e615763da46b0c7449303fb0c.jpg"
              alt=""
            />
          </div>
        </div>
      </div>
      <div class="footer-bottom">
        <p>Copyright © 2024 SWE (STREETWEAREAZY). Powered by Haravan</p>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { useUserStore } from "../stores/userStore";
import { ref } from "vue";
import { useRouter } from "vue-router"; // Thêm import này
import Menu from "./menu-link/Menu.vue";
import UserDropMenu from "./menu-link/UserDropMenu.vue";

const router = useRouter(); // Khai báo router
const userStore = useUserStore();
const user = ref({
  email: "",
  password: "",
  gender: true,
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
    !user.value.birthday ||
    !user.value.gender
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
      gender: user.value.gender,
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
