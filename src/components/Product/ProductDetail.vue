<template lang="">
  <Header></Header>
  <div class="boxspto">
    <p v-if="productStore.loading">Đang tải...</p>
    <p v-if="productStore.error" class="error">{{ productStore.error }}</p>
    <div
      class="boxsp"
      id="spmoinhat"
      v-if="!productStore.loading && !productStore.error"
    >
      <div
        class="sp"
        v-for="product in productStore.products"
        :key="product.id"
      >
        <div class="sale">{{ product.discount }}%</div>
        <img :src="product.image" :alt="product.name" />
        <div class="tensp">
          <h2>{{ product.name }}</h2>
        </div>
        <div class="price">
          {{ product.salePrice }}₫ <del> {{ product.originalPrice }}₫</del>
        </div>
        <div class="danhgia">
          <i
            v-for="star in 5"
            :key="star"
            class="fa-solid fa-star fa-2xs"
            :style="{ color: star <= product.rating ? '#ff4d4f' : '#ccc' }"
          ></i>
          <label for="" style="font-size: 9px">
            ({{ product.reviews }} lượt đánh giá)
          </label>
        </div>
        <p><label>Thương Hiệu:</label> {{ product.author }}</p>
        <p><label>Danh mục:</label> {{ product.categoryName }}</p>
        <p><label>Mô tả:</label> {{ product.description }}</p>
        <p><label>Giá:</label> {{ product.price }} USD</p>
        <p><label>Ngày mở bán:</label> {{ product.publishDate }}</p>
      </div>
    </div>
  </div>
  <footer>
    <Footer></Footer>
  </footer>
</template>
<script setup>
import { onMounted, ref, defineProps } from "vue";
import Header from "../menu-link/Header.vue";
import Footer from "../menu-link/Footer.vue";
import { useCategoryStore } from "../../stores/categoryStrore";
import { useProductStore } from "../../stores/productStore";
import { useRoute } from "vue-router";
const route = useRoute();
// Khai báo prop nhận từ route (giả sử là id của danh mục)
const categoryStore = useCategoryStore();
const productStore = useProductStore();
const productDetail = ref(null);
const productId = route.params.id;
console.log("Route productId:", productId);
onMounted(async () => {
  await productStore.fetchProduct(productId);
  console.log("Danh sách sản phẩm:", productStore.products);
  productDetail.value = productStore.products.find(
    (product) => product.id === Number(productId)
  );
});
</script>
<style lang=""></style>
