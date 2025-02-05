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
        <h1>Đăng nhập</h1>
        <h2>____</h2>
      </article>
      <aside>
        <div class="form-container">
          <form @submit.prevent="handleLogin">
            <div class="form-group">
              <div class="form-group">
                <input
                  type="email"
                  id="email"
                  name="email"
                  placeholder="Email"
                  v-model="model.email"
                />
              </div>
              <div class="form-group">
                <input
                  type="password"
                  id="password"
                  name="password"
                  placeholder="Mật khẩu"
                  v-model="model.password"
                />
              </div>
            </div>
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
            <button type="submit" class="submit-btn">ĐĂNG NHẬP</button>

            <!-- Link quay lại -->
            <a
              href="quenmatkhau.html"
              class="back-link"
              style="
                font-size: 14px;
                margin-right: 10px;
                text-decoration: none;
                color: black;
                font-weight: bold;
              "
              >Quên mật khẩu?</a
            ><strong style="font-size: 12px; font-weight: 100; color: #939090">
              hoặc
            </strong>
            <a
              href="dangky.html"
              style="
                text-decoration: none;
                font-size: 12px;
                font-weight: 200;
                color: black;
              "
              >đăng ký</a
            >
            <a href="index.html" class="back-link"
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
import Menu from "./menu-link/Menu.vue";
import UserDropMenu from "./menu-link/UserDropMenu.vue";
import { ref } from "vue";
import { useRouter } from "vue-router";
import axiosInstance from "../axios/asios";

const message = ref("");
const router = useRouter();
const model = ref({
  email: "",
  password: "",
});
//Login Funtion
const handleLogin = async () => {
  try {
    const response = await axiosInstance.post("/store/auth/token", {
      email: model.value.email,
      password: model.value.password,
    });
    message.value = "ĐĂNG NHẬP THÀNH CÔNG";
    localStorage.setItem("token", response.data.result.token);
    router.push({
      name: "home",
      query: {
        token: response.data.result.token,
      },
    });
  } catch (error) {
    message.value = error.response?.data?.message || "Đăng nhập thất bại!";
  }
};
</script>

<style></style>
