import { defineStore } from "pinia";
import axiosInstance from "../axios/asios";
export const useCategoryStore = defineStore("categories", {
  state: () => ({
    categories: [],
    loading: false,
    error: null,
  }),
  actions: {
    // Hàm lấy danh sách product
    async fetchCategory() {
      this.loading = true;
      this.error = null;
      try {
        const response = await axiosInstance.get("/store/categories");
        this.categories = response.data.result;
      } catch (error) {
        this.error = "Không thể tải danh sách sản phẩm ";
      } finally {
        this.loading = false;
      }
    },
  },
});
