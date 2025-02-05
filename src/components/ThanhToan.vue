<template>
  <div>
    <header>
      <div class="dongdau">
        <p>
          Miễn phí vận chuyển với đơn hàng trên 500K. Hàng pre-order còn được
          giảm thêm 5%.
        </p>
      </div>
      <div class="container">
        <div class="container1">
          <a href="/">
            <div class="swe"><img src="../assets/img/logo.webp" alt="" /></div>
          </a>
          <div class="seach">
            <input type="search" placeholder="Tìm kiếm sản phẩm..." />
            <button>
              <i
                class="fa-solid fa-magnifying-glass"
                style="color: #ffffff"
              ></i>
            </button>
          </div>
          <div class="login">
            <i
              class="fa-regular fa-user fa-xl"
              style="padding-top: 12px; margin-right: 10px"
            ></i>
            <p>
              <a href="dangnhap.html"
                >Đăng nhập / Đăng ký<br />Tài khoản của tôi</a
              >
            </p>
          </div>
          <div class="cart">
            <i class="fa-solid fa-bag-shopping fa-xl" style="padding: 10px"></i>
            <p><a href="detail.html">giỏ hàng</a></p>
          </div>
        </div>
      </div>
      <menu></menu>
    </header>

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
          <label for="" style="color: gray; font-size: 12px"
            ><i class="fa-solid fa-share"></i> Tiếp tục mua hàng</label
          >
        </div>
      </div>
    </aside>

    <footer>
      <div class="footer-content">
        <div class="newsletter">
          <h4>Nhận khuyến mãi</h4>
          <form>
            <input type="email" placeholder="Nhập email của bạn" />
            <button type="submit">
              <i class="fa fa-envelope"></i>
            </button>
          </form>
        </div>
        <div class="footer-sections">
          <div class="about-us">
            <h5>ABOUT US</h5>
            <p>
              Được thành lập vào cuối năm 2016 trong bối cảnh thời trang
              streetstyle dẫn nhẹn nhóm vào thị trường Việt Nam. Sau 6 năm phát
              triển, SWE - Street Wear Eazy với slogan Young kids with a
              mission™ đã chiếm được tình cảm của hầu hết các bạn trẻ yêu mến
              thời trang đường phố trên khắp cả nước.
            </p>
          </div>
          <div class="policy">
            <h5>CHÍNH SÁCH</h5>
            <ul>
              <li>Chính sách bảo mật</li>
              <li>Hướng dẫn mua hàng</li>
              <li>Phương thức thanh toán</li>
              <li>Chính sách giao nhận - vận chuyển</li>
              <li>Chính sách đổi và bảo hành sản phẩm</li>
            </ul>
          </div>
          <div class="store-info">
            <h5>HỆ THỐNG CỬA HÀNG SWE</h5>
            <ul>
              <li>Store 1: 44A Trần Quang Diệu, Quận 3</li>
              <li>Store 2: TNP Lý Tự Trọng, Quận 1</li>
              <li>Store 3: TNP Lê Lai, Quận 1</li>
              <li>
                Đại lý phân phối chính hãng: SN 84, Tổ 9, Hoàng Công Chất, P.
                Mường Thanh, TP Điện Biên
              </li>
            </ul>
            <div class="lienhe">
              <p>0357 420 420</p>
              <p>streetweareazy@gmail.com</p>
            </div>
          </div>
          <div class="social">
            <h5>FANPAGE</h5>
            <img
              src="../assets/img/z5992517442123_37d90b0e615763da46b0c7449303fb0c.jpg"
              alt=""
            />
          </div>
        </div>
      </div>
      <div class="footer-bottom">
        <p>Copyright © 2024 SWE (STREETWEAREAZY). Powered by Haravan</p>
      </div>
    </footer>
  </div>
</template>

<script setup>
import Menu from "./menu-link/Menu.vue";
</script>

<style></style>
