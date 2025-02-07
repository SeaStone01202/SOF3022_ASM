<template>
  <article>
    <p>Sản phẩm đang giảm giá</p>
    <div class="boxspto">
      <p v-if="productStore.loading">Đang tải...</p>
      <p v-if="productStore.error" class="error">{{ productStore.error }}</p>
      <div
        class="boxsp"
        id="spmoinhat"
        v-if="!productStore.loading && productStore.error"
      >
        <div class="sp">
          <div class="sale">23%</div>
          <img src="../../assets//img/sp1.webp" alt="" />
          <div class="tensp"><label>2BAR BABY TEE - BLUE</label></div>
          <div class="price">221,000₫ <del> 286,000₫</del></div>
          <div class="danhgia">
            <i class="fa-solid fa-star fa-2xs" style="color: #ff4d4f"></i
            ><i class="fa-solid fa-star fa-2xs" style="color: #ff4d4f"></i
            ><i class="fa-solid fa-star fa-2xs" style="color: #ff4d4f"></i
            ><i class="fa-solid fa-star fa-2xs" style="color: #ff4d4f"></i
            ><i class="fa-solid fa-star fa-2xs" style="color: #ff4d4f"></i>
            <label for="" style="font-size: 9px">(1 lượt đánh giá)</label>
          </div>
        </div>
      </div>
    </div>
    <p>BEST SELING-ITEMS</p>
    <div class="boxspto">
      <div class="boxsp" id="spmoinhat">
        <div class="sp">
          <div class="sale">23%</div>
          <img src="../../assets/img/sp10.webp" alt="" />
          <div class="tensp"><label>2BAR BABY TEE - BLUE</label></div>
          <div class="price">221,000₫ <del> 286,000₫</del></div>
          <div class="danhgia">
            <i class="fa-solid fa-star fa-2xs" style="color: #ff4d4f"></i
            ><i class="fa-solid fa-star fa-2xs" style="color: #ff4d4f"></i
            ><i class="fa-solid fa-star fa-2xs" style="color: #ff4d4f"></i
            ><i class="fa-solid fa-star fa-2xs" style="color: #ff4d4f"></i
            ><i class="fa-solid fa-star fa-2xs" style="color: #ff4d4f"></i>
            <label for="" style="font-size: 9px">(1 lượt đánh giá)</label>
          </div>
        </div>
      </div>
    </div>
    <p>FEEDBACK</p>
    <div class="ochuafb">
      <div class="feedback-section">
        <div class="khungfb1">
          <img src="../../assets//img/fb1.jpg" alt="" />
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
  </article>
</template>
<script setup>
import { onMounted } from "vue";
import { useProductStore } from "../../stores/productStore";
const productStore = useProductStore();

onMounted(() => {
  productStore.fetchProduct();
});
</script>
<style>
.error {
  color: red;
}
</style>
