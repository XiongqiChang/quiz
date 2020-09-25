import React, { Component } from 'react'

export default class Orders extends Component{
        

    constructor(props) {
        super(props);
        this.state = {
        }
    }

    async componentWillMount() {
        let orders = await (await fetch('http://localhost:8080/order')).json();
        this.setState({ orders });
    }
    render() {
        let { orders = [] } = this.state;
        return (<div>我是orders
            
                 <table >
                     <thead>
                        <tr>
                            <th>id</th>
                            <th>订单名称</th>
                            <th>订单价格</th> 
                            <th>订单数目</th>
                            <th>单位</th>
                            <th>操作</th>
                        </tr>
                </thead>
                <tbody>
                    {orders.map(({id,orderName, orderPrice, orderAmount, orderUnit}) =>
                            <tr >
                                 <td>{id}</td>
                                 <td>{orderName}</td>
                                 <td>{orderPrice}</td>
                                 <td>{orderAmount}</td>
                                <td>{orderUnit}</td>
                                 <td>删除</td>
                            </tr>
                   )}
                </tbody>
            </table>
        </div>
        );
    }


}