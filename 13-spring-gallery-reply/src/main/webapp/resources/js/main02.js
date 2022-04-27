let selectedItem = null;

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
            <span class="replyCount">${item.replyCount}</span>
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
  $("html,body").scrollTop(0);
  $("#detail").show();
  const imgSrc = $(this).find(".imgBox img").attr("src");
  $("#detail .imgBox img").attr("src", imgSrc);
  boardId = $(this).data("no");
  console.log(boardId);
  selectedItem = $(this);
  gsap.to("#detail", {
    top: 0,
    ease: "bounce",
    duration: 1.5,
  });
  const sendData = {
    boardId: boardId,
  };
  $.ajax({
    url: "ReplyList.do",
    data: sendData,
    type: "POST",
    success: function (res) {
      console.log(res);
      makeReplyList(res.replyList);
    },
  });
  return false;
});

$("body").on("click", ".list li button", function () {
  const sendData = {
    no: $(this).parent().data("no"),
    boardId: boardId,
  };
  $.ajax({
    url: "DeleteReply.do",
    data: sendData,
    type: "POST",
    success: function (res) {
      console.log(res);
      if (res.result > 0) {
        makeReplyList(res.replyList);
      } else {
        alert("시스템 오류입니다. 잠시후 다시 시도해 주세요.");
      }
      selectedItem.find(".replyCount").text(res.replyList.length);
    },
  });
});

$("#detail .btnClose").on("click", function () {
  gsap.to("#detail", {
    top: "-100%",
    ease: "back.in",
    duration: 1,
    onComplete: function () {
      $("#detail textarea").text("");
      $("#detail").hide();
      $("body").removeClass("overHidden");
    },
  });
});

$(".btns .btnClose02").on("click", function () {
  gsap.to("#detail", {
    top: "-100%",
    ease: "back.in",
    duration: 1,
    onComplete: function () {
      $("#detail textarea").text("");
      $("#detail").hide();
      $("body").removeClass("overHidden");
    },
  });
});

$("body").on("click", ".btns .btnDelete", function () {
  const sendData = {
    boardId: boardId,
  };
  console.log(sendData);

  $.ajax({
    url: "DeleteGallery.do",
    data: sendData,
    type: "POST",
    success: function (res) {
      console.log(res);
      const list = res.galleryList;
      if (res.replyResult > 0 && res.galleryResult > 0) {
        alert("삭제 되었습니다.");
        // 리스트 새로고침....
        $("#list > ul").html("");
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
                <span class="replyCount">${item.replyCount}</span>
              </a>
            </li>
          `;
        });
        $("#list > ul").html(output);
      } else {
        alert("시스템 오류입니다. 잠시후 다시 시도해 주세요.");
      }
    },
    error: function (err) {
      console.log(err);
    },
  });

  //  gsap 효과...
  gsap.to("#detail", {
    top: "-100%",
    ease: "back.in",
    duration: 1,
    onComplete: function () {
      $("#detail textarea").text("");
      $("#detail").hide();
      $("body").removeClass("overHidden");
    },
  });
});

$(".btns .btnDeleteAll").on("click", function () {
  const sendData = {
    boardId: boardId,
  };
  $.ajax({
    url: "DeleteAllReply.do",
    data: sendData,
    type: "POST",
    success: function (res) {
      console.log(res);
      if (res.result > 0) {
        alert("삭제 되었습니다.");
        makeReplyList(res.replyList);
      } else {
        alert("시스템 오류입니다. 잠시후 다시 시도해 주세요.");
      }
      selectedItem.find(".replyCount").text(res.replyList.length);
    },
  });
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
      makeReplyList(res.replyList);
      selectedItem.find(".replyCount").text(res.replyList.length);
    },
  });
});

function makeReplyList(_list) {
  const list = $("#detail .replyList .list");
  const replyList = _list;
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
}

$("#reply").on("keydown", function (e) {
  const contents = $(this).val();
  if (contents.length > 100) {
    alert("100글자 까지 입력 가능합니다.");
    $(this).val(contents.substr(0, 100));
    return;
  }
  $(".txtCount .count").text(contents.length);
});
