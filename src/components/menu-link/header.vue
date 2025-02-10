<template>
  <div class="dongdau">
    <p>
      Miễn phí vận chuyển với đơn hàng trên 500K. Hàng pre-order còn được giảm
      thêm 5%.
    </p>
  </div>
  <div class="container">
    <div class="container1">
      <a href="/">
        <div class="swe"><img src="/src/assets/img/logo.webp" alt="" /></div>
      </a>
      <div class="seach">
        <input type="search" placeholder="Tìm kiếm sản phẩm..." />
        <button>
          <i class="fa-solid fa-magnifying-glass" style="color: #ffffff"></i>
        </button>
      </div>
      <div class="login">
        <UserDropMenu></UserDropMenu>
      </div>
      <div class="cart">
        <router-link to="/payment"
          ><i class="fa-solid fa-bag-shopping fa-xl" style="padding: 10px"></i
        ></router-link>
      </div>
    </div>
  </div>
  <Menu></Menu>
</template>

<script setup>
import Menu from "./Menu.vue";
import UserDropMenu from "./UserDropMenu.vue";
</script>

<style></style>
