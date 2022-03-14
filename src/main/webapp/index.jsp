<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sortList.css">
		
		<meta charset="ISO-8859-1">
		<title>Sort list</title>
	</head>
<body>
	
	<form action="<%=request.getContextPath()%>/sortListGUIControlServlet" name="sortListForm" method="GET" >
		<div>
			<h3>Inserisci la sequenza di numeri separati da uno spazio</h3>
			<%if(request.getAttribute("strRequest") == null) {%>
			<textarea rows="7" cols="90" name="numbersSequence"></textarea>
			<%
			} else {%>
			<textarea rows="7" cols="90" name="numbersSequence"><%= request.getAttribute("strRequest") %></textarea>
			<%
			} %>
		
			<br><br>
			
			<label for="algorithm">Scegli un al algoritmo:</label>
			<select id="algorithm" name="algorithm">
			<%!
			String[] algorithmsValues = {"heapsort", "mergesort", "quicksort", "bubblesort", "selectionsort", "insertionsort"};
			String[] algorithmsOutput = {"HeapSort", "MergeSort", "QuickSort", "BubbleSort", "SelectionSort", "Insertionsort"};
			%>
			<%
			for(int i=0; i < algorithmsValues.length; i++) {
				if(request.getAttribute("strAlgorithm") != null && request.getAttribute("strAlgorithm").equals(algorithmsValues[i])) {
					%><option value="<%=algorithmsValues[i] %>" selected="selected"><%=algorithmsOutput[i] %></option><%
				} else {
					%><option value="<%=algorithmsValues[i] %>"><%=algorithmsOutput[i] %></option><%
				}
			}
			%>
			</select>	

			<br><br>

			<%if(request.getAttribute("strOrder") == null || request.getAttribute("strOrder").equals("asc")) {%>
			<input type="radio" id="asc" name="order" value="asc" checked>
  			<label for="asc">Asc</label><br>
  			<input type="radio" id="desc" name="order" value="desc">
  			<label for="desc">Desc</label><br>
  			<%
			} else {
  			%>
  			<input type="radio" id="asc" name="order" value="asc">
  			<label for="asc">Asc</label><br>
  			<input type="radio" id="desc" name="order" value="desc" checked>
  			<label for="desc">Desc</label><br>
  			<%
			}
  			%>
  			<br>
  			
  			<input type="submit" name="Sort list" value="Sort List">
  			
		</div>
	</form>
	
	<div>
		<h3>Risultato</h3>
		<%if(request.getAttribute("strResult") == null) {%>
		<textarea rows="7" cols="90" name="numbersSequence"></textarea>
		<%
		} else {%>
		<textarea rows="7" cols="90" name="numbersSequence"><%= request.getAttribute("strResult") %></textarea>
		<%
		} %>
	</div>
	
	
</body>
</html>