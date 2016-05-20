function open_in_new_tab(url)
{
	var win = window.open(url, '_blank');
	win.focus();
}

function pxToEm( px )
{
	px += "";
	px = px.split("px").join("");
	px = parseFloat(px)
	return ( 1/divForFindingEMSize.getBoundingClientRect().width ) * px;
}
	
function emToPx( em )
{
	em += "";
	em = em.split("em").join("");
	em = parseFloat(em)
	return ( divForFindingEMSize.getBoundingClientRect().width/1 ) * em;
}

function toggleClass(e, className)
{
	if( (typeof e) == "number" || (typeof e) == "string" || (typeof e) == "function")
	{
		return;
	}
	
	if(e.classList.contains(className))
	{
		e.classList.remove(className);
	}
	else
	{
		e.classList.add(className);
	}
}
