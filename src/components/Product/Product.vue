<template>
  <article>
    <p>Sản phẩm đang giảm giá</p>
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
          <router-link :to="`/product-detail/${product.id}`">
            <img :src="product.image" :alt="product.name" />
          </router-link>
          <div class="tensp">
            <router-link :to="`/product/${product.id}`">
              <label>{{ product.name }}</label>
            </router-link>
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
        </div>
      </div>
    </div>
  </article>
</template>

<script setup>
import { onMounted } from "vue";
import { useProductStore } from "../../stores/productStore";
import { useRouter } from "vue-router";

const productStore = useProductStore();
const route = useRouter();
onMounted(() => {
  productStore.fetchProduct();
});
</script>

<style>
.error {
  color: red;
}
</style>
