<template>
  <div class="khungchuamenu">
    <div class="menu">
      <ul class="navbar">
<<<<<<< HEAD
        <li class="nav-item">
          <router-link class="nav-link" to="/newarrival">new arrivals</router-link
          >
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/BestSelling">best-selling items</router-link
          >
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/Tops">tops</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/Bottoms">bottoms</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/outerWear">outerwear</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/Accessories">accessories</router-link
          >
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/SaleSaff">sale off</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/FashSale">flash sale</router-link>
=======
        <li
          v-for="category in categoriesWithPath"
          :key="category.id"
          class="nav-item"
        >
          <router-link class="nav-link" :to="category.path">
            {{ category.name }}
          </router-link>
>>>>>>> 9293942 (update product and category)
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { onMounted, computed } from "vue";
import { useCategoryStore } from "../../stores/categoryStrore";

const categoryStore = useCategoryStore();

onMounted(() => {
  categoryStore.fetchCategory();
});

// Computed property để đảm bảo mỗi category có thuộc tính path.
// Nếu category không có path, tạo đường dẫn mặc định theo dạng `/category/{id}`
const categoriesWithPath = computed(() =>
  categoryStore.categories.map((category) => ({
    ...category,
    path: category.path || `/category/${category.id}`,
  }))
);
</script>

<style>
.error {
  color: red;
}
</style>
