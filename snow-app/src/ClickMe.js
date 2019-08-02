import React, { Component } from 'react';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      bgColor: ""
    }
  }


  boxClick = (e) => {
    this.setState({
      bgColor: "red"
    })
  }

  render() {
    return (
      <div className="App">


        <article className='experimentsHolder'>
          <h2>Test 3</h2>
          <p>This is an example of an onClick event 'renderd' by react.</p>
          <div className="boxClickCss" 
          style={{backgroundColor: this.state.bgColor}}
           onClick={this.boxClick}>Click Me!</div>
        </article>

      </div>
    );
  }
}

export default App;