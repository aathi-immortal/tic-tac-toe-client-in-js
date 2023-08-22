




let buttons = new Array();
let id_prefix = "tile-";
let chanceX = true;
let isEmptybox = true
document.addEventListener("DOMContentLoaded", function () {
    
    loadTheButtons();
    addEventListenerToAllButtons();
    const oLabels = document.querySelectorAll(".tile label[for$='-o']");
    const xLabels = document.querySelectorAll(".tile label[for$='-x']");

    for(const node of oLabels)
    {
        node.addEventListener("click",function()
        {
            console.log("ki");
        })
    }
    // oLabels.forEach((oLabel) => {
    //     oLabel.addEventListener("click", function () {
    //         updateMark(this.parentElement, "O");
    //     });
    // });

    // xLabels.forEach((xLabel) => {
    //     xLabel.addEventListener("click", function () {
    //         updateMark(this.parentElement, "X");
    //     });
    // });

    
});

function updateMark(index, mark) {
    const tileDiv = buttons[index].querySelector("div");
    
    tileDiv.textContent = mark;
     // Update the text content
     console.log(tileDiv);
}



function addEventListenerToAllButtons()
{

        buttons.forEach((button,index)=>
        {
            button.isEmptybox = true;
            button.addEventListener("click",function()
            {
                    if(chanceX){
                        updateMark(index,'X');
                        
                    }
                    else
                    {
                        updateMark(index,'O');
                    }
                    chanceX = !chanceX;
                    this.isEmptybox = false;
            });
            button.addEventListener("mouseenter",function()
            {
                console.log(this);
                
                if(this.isEmptybox)
                {
                    console.log(chanceX);
                    
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


// let oLabel = document.querySelector(".tile label[for$='-o']");
// let xLabel = document.querySelector(".title label[for$='-x']");
// oLabel.forEach((label)=>
// {
//     label.addEventListener("click",function()
//     {
//         console.log("press -o");
//     })
// })

// xLabel.forEach((label)=>
// {
// label.addEventListener("click",()=>
// {
//     console.log("kiii");
// })
// });
