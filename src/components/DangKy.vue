<template>
  <div>
    <header>
      <Header></Header>
    </header>

    <div class="container-default-DK">
      <article>
        <h1>Tạo tài khoản</h1>
        <h2>____</h2>
      </article>
      <aside>
        <div class="form-container">
          <form>
            <div class="form-group">
              <input type="text" id="ho" name="ho" placeholder="Họ" />
            </div>
            <div class="form-group">
              <input type="text" id="ten" name="ten" placeholder="Tên" />
            </div>
            <div class="form-group">
              <label
                ><input type="radio" name="gender" value="nu" /> Nữ
                <input type="radio" name="gender" value="nam" /> Nam</label
              >
              <label></label>
            </div>
            <div class="form-group">
              <input type="date" id="dob" name="dob" />
            </div>
            <div class="form-group">
              <input type="email" id="email" name="email" placeholder="Email" />
            </div>
            <div class="form-group">
              <input
                type="password"
                id="password"
                name="password"
                placeholder="Mật khẩu"
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
