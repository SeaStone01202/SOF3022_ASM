<template>
  <header>
    <Header></Header>
  </header>
  <section>
    <div class="boxduongdan">
      <div class="duongdan">
        <span>Trang chủ</span>
        <span>/</span>
        <span>Danh mục</span>
        <span>/</span>
        <span>{{ categoryName }}</span>
        <!-- Sử dụng tên danh mục động -->
      </div>
    </div>

    <div class="container-default-NA">
      <!-- Tiêu đề danh mục được hiển thị động -->
      <h1>{{ categoryName }}</h1>

      <div class="filter-container">
        <div class="filter">
          <span class="filter-icon"><i class="fa-solid fa-filter"></i></span>
          <span style="margin-right: 10px">BỘ LỌC</span>
          <span>|</span>
        </div>
        <div class="filter-item-gia">
          <label>
            <select>
              <option>GIÁ SẢN PHẨM</option>
              <option>Dưới 150.000đ</option>
              <option>Từ 150.000đ đến 200.000đ</option>
              <option>Từ 350.000đ đến 500.000đ</option>
              <option>Trên 500.000đ</option>
            </select>
          </label>
        </div>
        <div class="filter-item-size">
          <label>
            <select>
              <option>KÍCH THƯỚC</option>
              <option>Small</option>
              <option>Medium</option>
              <option>Large</option>
            </select>
          </label>
        </div>
        <div class="filter-item-popular">
          <label>
            <select>
              <option>SẮP XẾP</option>
              <option>A-Z</option>
              <option>GIÁ TĂNG DẦN</option>
              <option>GIÁ GIẢM DẦN</option>
            </select>
          </label>
        </div>
      </div>

      <!-- Container hiển thị danh sách sản phẩm -->
      <div class="boxspto">
        <p v-if="productStore.loading">Đang tải...</p>
        <p v-if="productStore.error" class="error">{{ productStore.error }}</p>
        <div class="boxsp" v-if="!productStore.loading && !productStore.error">
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
            <h2>{{ product.name }}</h2>
            <p><label>Thương Hiệu:</label> {{ product.author }}</p>
            <p><label>Danh mục:</label> {{ product.categoryName }}</p>
            <p><label>Mô tả:</label> {{ product.description }}</p>
            <p><label>Giá:</label> {{ product.price }} USD</p>
            <p><label>Ngày mở bán:</label> {{ product.publishDate }}</p>
          </div>
        </div>
      </div>

      <div class="boxspto">
        <div class="boxsp" id="sptheonhasx"></div>
      </div>
    </div>
  </section>

  <footer>
    <Footer></Footer>
  </footer>
</template>

<script setup>
import { onMounted, ref, defineProps } from "vue";
import Header from "./menu-link/Header.vue";
import Footer from "./menu-link/Footer.vue";
import { useCategoryStore } from "../stores/categoryStrore";
import { useProductStore } from "../stores/productStore";
// Khai báo prop nhận từ route (giả sử là id của danh mục)
const props = defineProps({
  id: {
    type: String,
    required: true,
  },
});

// Khởi tạo store danh mục và store sản phẩm
const categoryStore = useCategoryStore();
const productStore = useProductStore();

// Biến chứa tên danh mục hiển thị trong breadcrumb và tiêu đề
const categoryName = ref("");

// Khi component được mounted, fetch dữ liệu danh mục và sản phẩm theo id
onMounted(async () => {
  // Nếu danh sách danh mục chưa được load, gọi API lấy danh mục
  if (categoryStore.categories.length === 0) {
    await categoryStore.fetchCategory();
  }
  // Tìm danh mục có id trùng với prop truyền vào
  const cat = categoryStore.categories.find(
    (category) => category.id == props.id
  );
  // Nếu tìm thấy, lấy tên danh mục; nếu không, sử dụng giá trị mặc định
  categoryName.value = cat ? cat.name : "Danh mục";

  // Gọi API lấy danh sách sản phẩm của danh mục (giả sử fetchProduct nhận tham số id)
  await productStore.fetchProduct(props.id);
});
</script>

<style>
/* Giữ nguyên style của bạn */
.error {
  color: red;
}
.product-item {
  /* Ví dụ style cho sản phẩm, bạn có thể điều chỉnh lại */
  margin-bottom: 1rem;
}
</style>
