import axiosInstance from "../asios";

export default {
  install: (app) => {
    app.config.globalProperties.$axios = axiosInstance; // Gắn vào global properties
  },
};
