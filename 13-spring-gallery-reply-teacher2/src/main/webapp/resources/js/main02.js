$.ajax({
  url: "JsonList02.do",
  success: function (res) {
    console.log(res);
    const list = res.galleryList;
    let output = "";
    $.each(list, function (idx, item) {
      console.log(item);
      const categories = item.category.split(",").join(" ");
      //console.log(categories);
      output += `
        <li class="item ${categories}" data-no="${item.no}">
          <a href="">
            <div class="imgBox">
              <img src="${item.img}" alt="" />
            </div>
            <div class="info">
              <h2>${item.title}</h2>
              <p class="desc">${item.contents}</p>
            </div>
          </a>
        </li>
      `;
    });
    $("#list > ul").html(output);
    //Fancybox.bind("[data-fancybox]");
    let grid = null;
    $("#list ul").imagesLoaded(function () {
      grid = $("#list ul").isotope({
        itemSelector: ".item",
        layoutMode: "masonry",
      });

      $("#filter li").on("click", function () {
        $(this).addClass("on").siblings("li").removeClass("on");
        const filtering = $(this).data("filter");
        console.log(filtering);
        grid.isotope({
          filter: "." + filtering,
        });
      });
    });
  },
});

let boardId;

// dom 생성 전 이벤트 걸때는 body에 걸고 매개변수로 위치를 남긴다
$("body").on("click", "#list li", function () {
  $("body").addClass("overHidden");
  $("#detaie").show();
  $("html,body").scrollTop(0);
  const imgSrc = $("this").find(".imgBox img").attr("src");
  $("#detail .imgBox img").attr("src", imgSrc);
  boardId = $(this).data("no");
  return false;
});

$("#detail .btnClose").on("click", function () {
  $("body").removeClass("overHidden");
});

$("#detail .btnReply").on("click", function () {
  const reply = $("#detail textarea").val();
  const sendData = {
    boardId: boardId,
    reply: reply,
  };
  $.ajax({
    url: "InsertReply.do",
    type: "POST",
    data: sendData,
    success: function (res) {
      console.log(res);
      const list = $("#detail .replyList .list");
      const replyList = res.replyList;
      let output = "";
      $("#detail textarea").val("");
      list.html("");
      $.each(replyList, function (idx, item) {
        output += `
                  <li data-no="${item.no}" data-boardId="${item.boardId}">
                    <div class="txt">${item.reply}</div>
                    <button><span class="material-icons">delete</span></button>
                  </li>
                  `;
      });
      list.append(output);
    },
    error: function (err) {
      console.log(err);
    },
  });
});
