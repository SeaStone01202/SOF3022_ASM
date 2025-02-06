<template>
       <div class="dongdau">
        <p>
          Miễn phí vận chuyển với đơn hàng trên 500K. Hàng pre-order còn được
          giảm thêm 5%.
        </p>
      </div>
      <div class="container">
        <div class="container1">
          <router-link to="/"><div class="swe"><img src="/src/assets/img/logo.webp" alt="" /> </div></router-link>
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
            <i class="fa-regular fa-user fa-xl" style="padding-top: 12px; margin-right: 10px"></i>
            <div class="links">
                <p>
                <router-link to="/register">Đăng kí</router-link>
                </p>
                <p>
                <router-link to="/login">/ Đăng nhập</router-link>
                </p>
            </div>
            </div>
          <div class="cart">
            <router-link to="/payment"><i class="fa-solid fa-bag-shopping fa-xl" style="padding: 10px"></i></router-link>
           
          </div>
        </div>
      </div>
      <Menu></Menu>
     
</template>

<script setup>
import Menu from './Menu.vue';
</script>

<style>

</style>