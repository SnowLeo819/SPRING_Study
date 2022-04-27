$.ajax({
  url: "JsonList.do",
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
          <a href="${item.img}" data-caption="${item.title}" data-fancybox="${categories}">
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
    Fancybox.bind("[data-fancybox]");
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
