var HotMoviesItem = React.createClass({
  render: function () {
    return (
      <div className="col-sm-6 col-md-4">
        <div className="hot-movies-item thumbnail">
          <img src={this.props.data.post_img_url} alt={this.props.data.name}/>
          <div className="caption">
            <h3>{this.props.data.name}</h3>
            <p>
              {this.props.data.marks}分&nbsp;
              {this.props.data.is3d ? <span className="badge">3D</span> : null}&nbsp;
              {this.props.data.isimax ? <span className="badge">IMAX</span> : null}
            </p>
            <p className="buy-btn-wrapper"><a href="detail.html" className="btn btn-primary" role="button">选座购票</a></p>
          </div>
        </div>
      </div>
    );
  }
})

var HotMovies = React.createClass({
  getInitialState: function () {
    return {hotMovieList: []};
  },
  componentDidMount: function() {
    $.ajax({
      url: this.props.url,
      dataType: 'json',
      cache: false,
      success: function(data) {
        this.setState({hotMovieList: data}, null);
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(this.props.url, status, err.toString());
      }.bind(this)
    });
  },
  render: function () {
    return (
      <div>
        <h2>正在热映</h2>
        <div className="row">
          {this.state.hotMovieList.map(function (movie) {
            return (
              <HotMoviesItem key={movie.mid} data={movie}/>
            );
          })}
        </div>
      </div>
    );
  }
});

ReactDOM.render(
  <HotMovies url="/api/hotmovies"/>,
  $("#hot-movies")[0]
);
