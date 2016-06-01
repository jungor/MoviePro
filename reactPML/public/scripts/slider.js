var Slider = React.createClass({
  render: function () {
    return (
      <div className="flexslider">
        <ul className="slides">
          <li>
            <img src="./img/slider1.jpg"/>
            <p className="flex-caption">《寒战2》推广曲《两陷》MV全球首发 笔笔称“还想演</p>
          </li>
          <li>
            <img src="./img/slider2.jpg"/>
            <p className="flex-caption">吴彦祖讲述《魔兽》拍摄 饰演大反派超级过瘾</p>
          </li>
          <li>
            <img src="./img/slider3.jpg"/>
            <p className="flex-caption">《X战警》主创与中国网红聊啥了？变种人要上太空？</p>
          </li>
          <li>
            <img src="./img/slider4.jpg"/>
            <p className="flex-caption">看《独立日2》你要知道的一些事情</p>
          </li>
        </ul>
      </div>
    );
  }
});

ReactDOM.render(
  <Slider />,
  $('#post-slider')[0]
);

var flexslider = $('.flexslider');
flexslider.flexslider({
  animation: "slide"
});
