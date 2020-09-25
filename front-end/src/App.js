import React from 'react';
import { BrowserRouter,Route,Switch,Link } from 'react-router-dom'
import './App.css';
import Products from './components/Products';
import Orders from './components/Orders';

function App() {
  return (

    <BrowserRouter>
      <div className="App">
      <div >
          <Link to={"/addProduct"}> 添加商品</Link><br></br>
          <Link to={"/orders"}>订单列表</Link><br></br>
          
      </div>
      <Switch>  
          <Route exact path={"/"} component={Products}></Route>
          <Route path={"/orders"} component={Orders}></Route>   
      </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
