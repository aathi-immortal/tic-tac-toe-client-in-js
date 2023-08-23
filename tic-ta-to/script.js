let buttons = new Array();
let id_prefix = "tile-";
let chanceX = true;
let isEmptybox = true

let stomp = null;
document.addEventListener("DOMContentLoaded", function () {
    connect();
    loadTheButtons();
    addEventListenerToAllButtons();
    
    
});
function connect()
{
    const socket = new SockJS("http://localhost:8080/game");
    stomp = Stomp.over(socket);
    stomp.connect({},function(frame)
    {
        console.log("connected");
        stomp.subscribe("/gameRoom/public",function(frame)
        {   
            console.log(message);
            message = JSON.parse(frame.body);
            
            let symbol = message.messageContent;
            let blockId = message.blockId;
            
            updateMark(blockId,symbol);
            
        });
    });
}

function sendMessage(symbol,id)
{
    let movesOb = 
    {
        blockId:id,
        messageContent: symbol

    }
    stomp.send("/app/move",{},JSON.stringify(movesOb));
}
function updateMark(index, mark) {
    
    const tileDiv = buttons[index].querySelector("div");
    
    tileDiv.textContent = mark;
     // Update the text content
     
}



function addEventListenerToAllButtons()
{

        buttons.forEach((button,index)=>
        {
            button.isEmptybox = true;
            button.addEventListener("click",function()
            {
                    let symbol = "O";
                    if(chanceX){
                        updateMark(index,'X');
                        symbol = "X"
                    }
                    else
                    {
                        updateMark(index,'O');
                    }
                    // send the changes into server using socket connection
                    
                    sendMessage(symbol,index);
                    chanceX = !chanceX;
                    this.isEmptybox = false;
            });
            button.addEventListener("mouseenter",function()
            {
     
                
                if(this.isEmptybox)
                {
     
                    
                    if(chanceX){
                        
                        const tileDiv = buttons[index].querySelector("div");
    
                        tileDiv.textContent = 'X'; // Update the text content
                        
                    }
                    else
                    {
                        const tileDiv = buttons[index].querySelector("div");
    
                        tileDiv.textContent = 'O'; // Update the text content


                    }
                    
                }
                    
            });
            button.addEventListener("mouseleave",function()
            {
                
                 if(this.isEmptybox)
                 {

                  
                             
                        const tileDiv = buttons[index].querySelector("div");
    
                        tileDiv.textContent = ''; // Update the text content
                 }
                     
                        
                    
            });
        })
    
}
function loadTheButtons()
{
    for(let i = 0;i<9;i++)
    {
        buttons.push(document.getElementById(id_prefix + i));
    }
}



