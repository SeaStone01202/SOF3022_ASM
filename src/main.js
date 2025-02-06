import { createApp } from "vue";
// import './style.css'
import "../src/assets/css/newarrival.css"
import "../src/assets/css/dangky.css";
import "../src/assets/css/header.css";
import "../src/assets/css/cart.css";
import "../src/assets/css/Login.css";
import "../src/assets/css/BoxDuongDan.css";
import "../src/assets/css/container-default.css";
// import '../src/assets/css/index.css'
import { createPinia } from "pinia";
import App from "./App.vue";
import router from "./router";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import axiosPlugin from "./axios/plugins/axiosPlugin";
import "@fortawesome/fontawesome-free/css/all.min.css";
const app = createApp(App);
const pinia = createPinia();
app.use(axiosPlugin);
app.use(pinia);
app.use(router);
app.mount("#app");
