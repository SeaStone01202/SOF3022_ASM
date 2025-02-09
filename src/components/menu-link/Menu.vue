<template>
  <div class="khungchuamenu">
    <div class="menu">
      <ul class="navbar">
        <li
          v-for="category in categoriesWithPath"
          :key="category.id"
          class="nav-item"
        >
          <router-link class="nav-link" :to="category.path">
            {{ category.name }}
          </router-link>
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
