
var ref = false;

function isEmail(id)
{
	alphaNum = false;
	var i = 0 , n = id.length;
	while(i<n && ((id.charAt(i)>="0" && id.charAt(i)<="9") || (id.charAt(i)>="a" && id.charAt(i)<="z") || id.charAt(i) == "." || id.charAt(i) == "-" || id.charAt(i) == "_"))
		i++;
	if(i==n || id.charAt(i)!='@')
		return false;
	else
	{
		i++;
		while(i<n && ((id.charAt(i)>="0" && id.charAt(i)<="9") || (id.charAt(i)>="a" && id.charAt(i)<="z") || id.charAt(i) == "." || id.charAt(i) == "-" || id.charAt(i) == "_" || id.charAt(i) == "." ))
			i++;
		if(i==n)
			return true;
		else
			return false;
	}
}

function verif()
{
	var id = document.getElementById("email").value;
	var pw = document.getElementById("pw").value;

	if(pw!="" && id!="")
	{
		if( !isEmail(id))
		{
			var alert = document.getElementById("status");
			alert.setAttribute("class", "alert alert-danger");
			alert.innerHTML = "email entree est invalide.";
			alert.style.visibility = 'visible';
			ref = true;
		}
		else {
				refrech();
				window.location.replace("/loginClassic?status=online&email="+id+"&pw="+pw);
			}
	}
	else
	{
		var alert = document.getElementById("status");
		alert.setAttribute("class", "alert alert-danger");
		alert.innerHTML = "le password ou l'identifiant est manquant.";
		alert.style.visibility = 'visible';
		ref = true;
	}
	
}

function refrech()
{
	if(ref==true)
	{
		var alert = document.getElementById("status");
		alert.setAttribute("class", "");
		alert.style.visibility = 'hidden';	
		ref = false;
	}
	
}