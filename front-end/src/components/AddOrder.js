import React, { Component } from 'react'

export default class AddProduct extends Component{
    state = {
        productName: '',
        price: '',
        unit: '',
        pictureUrl: ''
        
    }
    handleInput = (event)=>{
      
        this.setState({
            [event.target.name]: event.target.value
        }
           
        )
    }
    handleSubmit=(event)=>{
        //console.info(this.state.name,this.state.gender,this.state.description)
        event.preventDefault();
        console.log((JSON.stringify(this.state)));
        alert(JSON.stringify(this.state));

        const {productName,
            price,
            unit,
            pictureUrl
           } = this.state;
                        fetch('http://localhost:8080/product', {
                             method: 'post',
    // 使用fetch提交的json数据需要使用JSON.stringify转换为字符串
                       body: JSON.stringify({
                            productName,
                            price,
                            unit,
                            pictureUrl
                        }),
                            headers: {
                                'Access-Control-Allow-Origin': '*',
                                 'Content-Type': 'application/json'
                            }
    })
    .then((res) => res.json())
    .then((res) => {
      // 当添加成功时，返回的json对象中应包含一个有效的id字段
      // 所以可以使用res.id来判断添加是否成功
      if (res.id) {
        alert('添加成功');
        this.setState({
            productName: '',
            price: '',
            unit: '',
            pictureUrl: ''
        });
      } else {
        alert('添加失败');
      }
    })
    .catch((err) => console.error(err));



    }
    handleClick = (event)=>{
        let product = {
            productName: event.target.state.productName,
            price: event.target.state.price,
            unit: event.target.state.gender,
            pictureUrl: event.target.state.pictureUrl,
            

        }
        console.log(product);
    }
    
    render() {
        return ( 
            <div>
                <form onSubmit={this.handleSubmit}>
                    <input type="text" id='productName' name='productName' value={this.state.productName} onChange={this.handleInput}></input> <br></br>
                    <input  type="text" id='price' name='price'   value={this.state.price} onChange={this.handleInput} ></input> <br></br>
                    <input  type="text" id='unit' name='unit'   value={this.state.unit}  onChange={this.handleInput}></input> <br></br>
                    <input type="text" id='pictureUrl' name='pictureUrl'   value={this.state.pictureUrl}  onChange={this.handleInput}></input> <br></br>
                    <br></br>
                    <input type='submit' value='submit' disabled={!this.state.productName || !this.state.price || !this.state.unit || !this.state.pictureUrl} /* onClick={this.handleClick} */></input>
                </form> 
                
            </div>

        );
    }
}