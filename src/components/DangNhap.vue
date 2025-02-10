<template>
  <div>
    <Header></Header>
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
            <router-link to="/forgot-password"
              ><a
                class="back-link"
                style="
                  font-size: 14px;
                  margin-right: 10px;
                  text-decoration: none;
                  color: black;
                  font-weight: bold;
                "
                >Quên mật khẩu?</a
              ><strong
                style="font-size: 12px; font-weight: 100; color: #939090"
              >
                hoặc
              </strong></router-link
            >
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
            <router-link to="/"
              ><a class="back-link"
                ><strong style="font-size: 14px; margin-right: 10px">← </strong
                >Quay lại trang chủ</a
              >
            </router-link>
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
