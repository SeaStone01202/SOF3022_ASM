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
          <div class="swe"><img src="../assets/img/logo.webp" alt="" /></div>
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
            <p><a href="detail.html">Giỏ hàng</a></p>
          </div>
        </div>
      </div>
      <Menu></Menu>
      <img src="../assets/img/slideshow_1.webp" alt="" />
    </header>
    <aside>
      <div class="odichvu">
        <div class="dichvu">
          <div class="dichvu1">
            <i class="fa-solid fa-rocket"></i>
            <p style="font-size: 13px">Giao hàng miễn phí</p>
            <p style="font-size: 11px">với đơn hàng từ 500K trở lên</p>
          </div>
        </div>
        <div class="dichvu">
          <div class="dichvu1">
            <i class="fa-solid fa-phone"></i>
            <p style="font-size: 13px">Hỗ trợ 24/7</p>
            <p style="font-size: 11px">Hỗ trợ online / offline 24/7</p>
          </div>
        </div>
        <div class="dichvu">
          <div class="dichvu1">
            <i class="fa-solid fa-boxes-stacked"></i>
            <p style="font-size: 13px">Miễn phí đổi trả</p>
            <p style="font-size: 11px">Trong vòng 7 ngày</p>
          </div>
        </div>
        <div class="dichvu">
          <div class="dichvu1">
            <i class="fa-solid fa-globe"></i>
            <p style="font-size: 13px">Đặt hàng trực tuyến</p>
            <p style="font-size: 11px">Hotline: 0357 420 420</p>
          </div>
        </div>
      </div>
    </aside>
    <Product></Product>
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
import Product from "./Product/Product.vue";
</script>
<style></style>
