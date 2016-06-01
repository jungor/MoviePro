/**
 * Created by jungor on 2016/5/29/029.
 */

var isRegister = !!window.location.search.match('register=1');


var LoginBtn = React.createClass({
  render: function () {
    return (
      <div className="col-sm-offset-2 col-sm-3">
        <button type="submit" className="btn btn-primary" id="loginBtn">登录</button>
      </div>
    );
  }
});

var RegisterBtn = React.createClass({
  render: function () {
    return (
      <div className="col-sm-offset-2 col-sm-3">
        <button type="submit" className="btn btn-primary" id="registerBtn">注册</button>
      </div>
    );
  }
});

var SignForm = React.createClass({
  render: function () {
    return (
      <div>
        <h2>欢迎加入MoviePro!</h2>
        <form className="form-horizontal" id={isRegister ? "registerForm" : "loginForm"}>
          <div className="form-group">
            <label for="inputEmail3" className="col-sm-3 control-label">用户名：</label>
            <div className="col-sm-3">
              <input type="text" className="form-control" id="inputEmail3" placeholder="请输入你的用户名" name="name" required/>
            </div>
          </div>
          <div className="form-group">
            <label for="inputPassword3" className="col-sm-3 control-label">密码：</label>
            <div className="col-sm-3">
              <input type="password" className="form-control" id="inputPassword3" placeholder="请输入你的密码" name="password" required/>
            </div>
          </div>
          <div className="form-group">
            {isRegister ? <RegisterBtn /> : <LoginBtn />}
            <div className="col-sm-3">
              <button type="reset" className="btn btn-danger">清空</button>
            </div>
          </div>
        </form>
      </div>
    );
  }
});

ReactDOM.render(
  <SignForm isRegister={isRegister} />,
  $("#signFormContainer")[0]
);

$('#loginForm').on('submit', function (e) {
  e.preventDefault();
  var data = $('#loginForm').serialize();
  $.post({
    // url: "http://172.18.43.53:8080/moviepro/login",
    url: "/api/login",
    dataType: 'json',
    cache: false,
    data: data,
    success: function(data) {
      if (data.code) {
        cookie.set("username", data.message);
        window.location = "/";
      } else {
        $('#loginBtn').blur();
        $('#loginForm .form-group').addClass("has-error");
      }
    },
    error: function(xhr, status, err) {
      console.error(err);
    }
  });
  return false;
});

$('#registerForm').on('submit', function (e) {
  e.preventDefault();
  var data = $('#registerForm').serialize();
  $.post({
    url: "http://172.18.43.53:8080/moviepro/register",
    dataType: 'json',
    cache: false,
    data: data,
    success: function(data) {
      if (data.code) {
        cookie.set("username", data.message);
        window.location = "/";
      } else {
        $('#registerBtn').blur();
        $('#registerForm .form-group').addClass("has-error");
      }
    },
    error: function(xhr, status, err) {
      console.error("hehe");
    }
  });
  return false;
});
