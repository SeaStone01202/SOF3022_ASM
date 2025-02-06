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
                <span>Tops</span>
            </div>
        </div>  
   
        <div class="container-default-NA">
            <h1>Tops</h1>    
         
            <div class="filter-container">
                <div class="filter">
                    <span class="filter-icon"><i class="fa-solid fa-filter"></i></span>
                    <span style="margin-right: 10px;">BỘ LỌC</span>
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
            <div class="boxspto">
                <div class="boxsp" id="loadsp"></div>
                <!-- Chổ này mốt sẽ là sản phẩm -->
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
import Footer from "./menu-link/Footer.vue"
import Header from "./menu-link/header.vue";
</script>

<style>

</style>