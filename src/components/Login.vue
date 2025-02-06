<template>
  <div>
    <header>
     <Header></Header>
    </header>

    <div class="container-default-DK">
      <article>
        <h1>Đăng nhập</h1>
        <h2>____</h2>
      </article>
      <aside>
        <div class="form-container">
          <form>
            <div class="form-group">
              <div class="form-group">
                <input
                  type="email"
                  id="email"
                  name="email"
                  placeholder="Email"
                />
              </div>
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
    <Footer></Footer>
    </footer>
  </div>
</template>

<script setup>
import Footer from "./menu-link/Footer.vue"
import Header from "./menu-link/header.vue";
</script>

<style></style>
