<template>
  <div id="demo" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000"> <!-- Thêm data-bs-interval -->
  
  <!-- Indicators/dots -->
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
  </div>
  
  <!-- The slideshow/carousel -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/src/assets/img/slideshow_1.webp" alt="Los Angeles" class="d-block" style="width:100%">
    </div>
    <div class="carousel-item">
      <img src="/src/assets/img/slideshow_2.webp" alt="Chicago" class="d-block" style="width:100%">
    </div>
  </div>
  
  <!-- Left and right controls/icons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>
</template>

<script setup>
import { onMounted } from "vue";
import { Carousel } from "bootstrap";

onMounted(() => {
  const carouselElement = document.querySelector("#demo");
  if (carouselElement) {
    new Carousel(carouselElement, {
      interval: 2000, // Tự động chạy sau 2 giây
      ride: "carousel",
    });
  }
});
</script>

<style>

</style>