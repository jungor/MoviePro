var username = cookie.get("username")

var NavBar = React.createClass({
  render: function () {
    return (
      <nav className="navbar navbar-default">
        <div className="container-fluid">
          <div className="navbar-header">
            <button type="button" className="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span className="sr-only">Toggle navigation</span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
            </button>
            <a className="navbar-brand" href="/">MoviePro</a>
          </div>

          <div className="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            {window.location.pathname == "/" || window.location.pathname == "/index.html" ?
            <form className="navbar-form navbar-left" role="search">
              <div className="form-group">
                <input id="searchIpt" type="text" className="form-control" placeholder="请输入电影或影院"
                       list="search-result-list"/>
                <datalist id="search-result-list">
                  <option value="愤怒的小鸟"></option>
                  <option value="夜孔雀"></option>
                  <option value="美国队长3"></option>
                  <option value="再见，在也不见"></option>
                  <option value="百鸟朝凤"></option>
                  <option value="分歧者3：忠诚世界"></option>
                </datalist>
              </div>
            </form> : null}
            <ul className="nav navbar-nav navbar-right">
              {username ? <li><a href="personal.html">{username}</a></li> : null}
              {username ? <li><a href="#" id="logoutBtn">退出</a></li> : null}
              {username ? null: <li><a href="login.html">登录</a></li>}
              {username ? null : <li><a href="login.html?register=1">注册</a></li> }
            </ul>
          </div>
        </div>
      </nav>
    );
  }
});

ReactDOM.render(
  <NavBar />,
  $("#NavBarContainer")[0]
);

$("#logoutBtn").on('click', function (e) {
  e.preventDefault();
  $.post({
    url: "/api/logout",
    dataType: 'json',
    cache: false,
    success: function(data) {
      if (data.code) {
        cookie.remove("username");
        window.location = "/"
      } else {

      }
    },
    error: function(xhr, status, err) {
      console.error("hehe");
    }
  });
});
