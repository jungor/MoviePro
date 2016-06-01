/**
 * Created by jungor on 2016/5/30/030.
 */

var infoDict = {
  "name": ["用户名", "text", "请输入新的用户名"],
  "password": ["密码", "password", "请输入新的密码"],
  "email": ["邮箱", "email", "请输入新的邮箱"],
  "sex": ["性别（女0男1）", "number", "请输入新的性别（女0男1）"],
  "telephone": ["电话", "tel", "请输入新的电话"],
  "description": ["个人简介", "text", "请输入新的个人简介"],
};

var data = {
  "name": "卢锡安",
  "password": "123",
  "email": "gege",
  "sex": 1,
  "telephone": "43242",
  "description": "gwere",
}

function infoToState(data) {
  var rtn = [];
  for(var k in data) {
    if (data.hasOwnProperty(k)) {
      rtn.push({
        key: k,
        chinese: infoDict[k][0],
        type: infoDict[k][1],
        placeholder: infoDict[k][2],
        value: k == "password" ? "***": data[k]
      })
    }
  }
  return rtn;
}

var InfoBlock = React.createClass({
  render: function () {
    return (
      <div className="info-block">
        <ul className="info">
          <li className="info-key">{this.props.info.chinese}</li>
          <li className="info-value">{this.props.info.value}</li>
          <li className="info-edit">
            <a href="#">修改</a>
          </li>
        </ul>
        <div className="form-group hidden">
          <label>{this.props.info.chinese}</label>
          <input type={this.props.info.type} className="form-control" id="username" placeholder={this.props.info.placeholder} name={this.props.info.key}/>
          <button className="btn btn-warning btn-sm btn-commit">确定</button>
          <button className="btn btn-default btn-sm btn-cancel">取消</button>
        </div>
      </div>
    );
  }
});


var PersonalInfo = React.createClass({
  getInitialState: function () {
    return {userInfo: infoToState(data)}
  },
  render: function () {
    return (
      <section className="col-md-8 personal-info">
        <section className="info-page">
          <header>
            <h2>我的信息</h2>
          </header>
          {this.state.userInfo.map(function (info) {
            return (
              <InfoBlock info={info}/>
            );
          })}
        </section>
      </section>
    );
  }
});

ReactDOM.render(
  <PersonalInfo />,
  $("#personalInfoContainer")[0]
);

var nav = $(".nav-aside").children();
var personalInfo = $(".personal-info");
var infoPage = $(".info-page");
var editPage = $(".edit-page");
var orderList = $(".order-list");
var editButton = $(".btn-edit");
var editForm = $(".form-group");
var info = $(".info");
nav.click(function() {
  if (!$(this).hasClass("active")) {
    nav.toggleClass("active");
    personalInfo.toggleClass("hidden");
    orderList.toggleClass("hidden");
  }
});
editButton.click(function() {
  infoPage.toggleClass("hidden");
  editPage.toggleClass("hidden");
});
$(".info-edit").click(function(e) {
  e.preventDefault();
  editForm.addClass("hidden");
  info.removeClass("hidden");
  $(this).parents(".info-block").children(".info").addClass("hidden");
  $(this).parents(".info-block").children(".form-group").removeClass("hidden");
});
$(".btn-cancel").click(function() {
  $(this).parents(".info-block").children(".info").removeClass("hidden");
  $(this).parents(".info-block").children(".form-group").addClass("hidden");
});
