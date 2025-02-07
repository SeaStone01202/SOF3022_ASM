import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import("../components/TrangChu.vue"),
    },
    {
      path: "/login",
      name: "login",
      component: () => import("../components/DangNhap.vue"),
    },
    {
      path: "/register",
      name: "register",
      component: () => import("../components/DangKy.vue"),
    },
    {
      path: "/forgot-password",
      name: "forgotpassword",
      component: () => import("../components/QuenMatKhau.vue"),
    },
    {
      path: "/payment",
      name: "payment",
      component: () => import("../components/ThanhToan.vue"),
    },
  ],
});

export default router;
