<template>
  <div>
   <Header></Header>

    <div class="container-default">
      <article>
        <h1>Phục hồi mật khẩu</h1>
        <h2>____</h2>
      </article>
      <aside>
        <div class="form-container">
          <form>
            <div class="form-group">
              <h2>Phục hồi mật khẩu</h2>
              <div class="form-group">
                <input
                  type="password"
                  id="password"
                  name="password"
                  placeholder="Mật khẩu"
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
            <button type="submit" class="submit-btn">Gửi</button>

            <!-- Link quay lại -->
            <router-link to="/"><a class="back-link"
              ><strong style="font-size: 14px; margin-right: 10px">← </strong
              >Quay lại trang chủ</a> </router-link>
          </form>
        </div>
      </aside>
    </div>
    <Footer></Footer>
  </div>
</template>

<script setup>
import Header from './menu-link/Header.vue';
import Footer from "./menu-link/Footer.vue";
</script>

<style></style>
