<template>
  <div>
      <Header></Header>
    <aside>
      <div class="giohang">
        <div class="sanphamgiohang">
          <div class="boxduongdan">
            <div class="duongdan" style="width: 90%">
              <label for="">Có <b>3 sản phẩm</b> trong giỏ hàng</label>
            </div>
          </div>

          <div class="khunggiohang">
            <div class="hinh">
              <!-- <img src="public/img/<?=$product['image_01']?>" alt=""> -->
            </div>
            <div class="tenvagia">
              <!-- <label for=""><b><?=$product['name']?></b></label> -->
              <div class="duongdan" style="padding-top: 7px">
                <!-- <label for=""><?=$product['price']?>₫</label> -->
              </div>
            </div>
            <div class="xoagiohang">
              <!-- <a href="?mod=cart&act=delete&id=<?=$product['id']?>"><i class="fa-solid fa-delete-left"></i></a><br><br> -->
              <!-- <label for=""><b><?=$product['price']*$product['quantity']?>₫</b></label> -->
            </div>
          </div>
          <hr />

          <div class="khunggiohang">
            <div class="hinh">
              <img src="../assets/img/sp10.webp" alt="" />
            </div>
            <div class="tenvagia">
              <label for=""><b>STAR PLUSH CHARM - WHITE</b></label>
              <div class="duongdan" style="padding-top: 7px">
                <label for="">70,000₫</label>
              </div>
              <div class="quantity-control">
                <button class="quantity-btn">-</button>
                <input type="text" class="quantity-input" value="1" readonly />
                <button class="quantity-btn">+</button>
              </div>
            </div>
            <div class="xoagiohang">
              <i class="fa-solid fa-delete-left"></i><br /><br />
              <label for=""><b>70,000₫</b></label>
            </div>
          </div>
          <hr />
          <div class="khunggiohang">
            <div class="hinh">
              <img src="../assets/img/sp1.webp" alt="" />
            </div>
            <div class="tenvagia">
              <label for=""><b>STAR PLUSH CHARM - WHITE</b></label>
              <div class="duongdan" style="padding-top: 7px">
                <label for="">70,000₫</label>
              </div>
              <div class="quantity-control">
                <button class="quantity-btn">-</button>
                <input type="text" class="quantity-input" value="1" readonly />
                <button class="quantity-btn">+</button>
              </div>
            </div>
            <div class="xoagiohang">
              <i class="fa-solid fa-delete-left"></i><br /><br />
              <label for=""><b>70,000₫</b></label>
            </div>
          </div>
          <div class="khunggiohang">
            <div class="ghichu">
              <b style="font-size: 12px; color: gray">Ghi chú đơn hàng</b><br />
              <input type="text" />
            </div>
          </div>
        </div>
        <div class="thanhtoan">
          <div class="boxthanhtoan">
            <div class="thanhtoannho">
              <label for=""><b>Thông tin đơn hàng</b></label>
              <hr />
              <div class="tongtien">
                <div class="chutongtien" style="font-size: 12px; color: gray">
                  <b>Tổng tiền</b>
                </div>
                <div class="sotongtien" style="font-size: 16px; color: red">
                  <b>210.000₫</b>
                </div>
              </div>
              <hr />
              <a href="?mod=checkout&act=checkout"
                ><button>THANH TOÁN</button></a
              >
            </div>
          </div>
          <label for="" style="color: gray; font-size: 12px; margin-top: 20px;"
            ><i class="fa-solid fa-share"></i> Tiếp tục mua hàng</label>
        </div>
      </div>
    </aside>
      <Footer></Footer>
  </div>
</template>

<script setup>
import Footer from "./menu-link/Footer.vue"
import Header from "./menu-link/Header.vue";
</script>

<style></style>
