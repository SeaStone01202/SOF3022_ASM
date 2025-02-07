import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import("../components/Home.vue"),
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
    {
      path: "/newarrival",
      name: "newarrival",
      component: () => import("../components/NewArrival.vue"),
    },
    {
      path: "/Accessories",
      name: "Accessories",
      component: () => import("../components/Accessories.vue"),
    },
    {
      path: "/BestSelling",
      name: "BestSelling",
      component: () => import("../components/BestSelling.vue"),
    },
    {
      path: "/Bottoms",
      name: "Bottoms",
      component: () => import("../components/Bottoms.vue"),
    },
  
    {
      path: "/FashSale",
      name: "FashSale",
      component: () => import("../components/FashSale.vue"),
    },
    {
      path: "/outerWear",
      name: "PuterWear",
      component: () => import("../components/OuterWear.vue"),
    },
    {
      path: "/SaleSaff",
      name: "SaleSaff",
      component: () => import("../components/SaleSaff.vue"),
    },
    {
      path: "/Tops",
      name: "Tops",
      component: () => import("../components/Tops.vue"),
    },
  ],
});

export default router;
