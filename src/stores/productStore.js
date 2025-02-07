import { defineStore } from "pinia";
import axiosInstance from "../axios/asios";
import { ref } from "vue";
export const useProductStore = defineStore("product", {
  state: () => ({
    products: [],
    loading: false,
    error: null,
  }),
  actions: {
    // Hàm lấy danh sách product
    async fetchProduct() {
      this.loading = true;
      this.error = null;
      try {
        const response = await axiosInstance.get("/store/products");
        this.products = response.data.result;
      } catch (error) {
        this.error = "Không thể tải danh sách sản phẩm ";
      } finally {
        this.loading = false;
      }
    },
  },
});
