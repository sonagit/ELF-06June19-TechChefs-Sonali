function show(val) 
{
	document.getElementById("result").value+=val 
}
function calculate() 
{ 
    let x = document.getElementById("result").value 
    let y = eval(x) 
    document.getElementById("result").value = y 
} 
function clear() 
{ 
    document.getElementById("result").value = "" 
} 