<template>
  <div>
    <Header></Header>
    <Carousel></Carousel>
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
    <div class="ochuafb">
      <div class="feedback-section">
        <div class="khungfb1">
          <img src="../assets/img/fb1.jpg" alt="" />
          <img src="../assets/img/fb2.webp" alt="" />
        </div>
        <div class="khungfb2">
          <img
            src="../assets/img/fb3.webp"
            alt=""
            style="width: 100%; padding: 5px"
          />
          <div class="boxbefb">
            <img
              src="../assets/img/fb4.jpg"
              alt=""
              style="width: 50%; padding: 5px"
            />
            <img
              src="../assets/img/fb5.webp"
              alt=""
              style="width: 50%; padding: 5px"
            />
          </div>
        </div>
      </div>
    </div>
    <footer>
      <Footer></Footer>
    </footer>
  </div>
</template>

<script setup>
import Footer from "./menu-link/Footer.vue";
import Header from "./menu-link/Header.vue";
import Carousel from "./menu-link/Carousel.vue";
import Product from "./Product/Product.vue";
</script>
<style></style>
