/**
 * AutoEE version 0.0.1 - alpha javascript support.<br>
 * Requires JQuery
 */
// initialize listeners
/*
 * var listen would be set on page, which looks like
 * 
 * var listen = [ { "elemID" : "autoee7D34F6", "event" : [ { "on" : "click",
 * "dataType" : "json" } ] } ]; var watch would be set on page, which looks like
 * var watch=[{ "elemID" : "autoee89D903", "from" : "html/val/attr.x"]
 */

$(function() {
	// add forEach
	if (Array.prototype.forEach == undefined) {
		if (!Array.prototype.forEach) {
			Array.prototype.forEach = function(callback, thisArg) {
				var T, k;
				if (this == null) {
					throw new TypeError(" this is null or not defined");
				}
				var O = Object(this);
				var len = O.length >>> 0;
				if ({}.toString.call(callback) != "[object Function]") {
					throw new TypeError(callback + " is not a function");
				}
				if (thisArg) {
					T = thisArg;
				}
				k = 0;
				while (k < len) {
					var kValue;
					if (k in O) {
						kValue = O[k];
						callback.call(T, kValue, k, O);
					}
					k++;
				}
			};
		}
	}

	function retrieveElementValue(elemID, from) {
		var v = null;
		if (from == "val") {
			v = $("*[autoee='" + elemID + "']").val();
		} else if (from == "html") {
			v = $("*[autoee='" + elemID + "']").html();
		} else if (from.length > 5 && from.substring(0, 4) == "attr") {
			v = $("*[autoee='" + elemID + "']").attr(
					from.substring(6, from.length));
		}
		return v;
	}

	// init watch
	var watchedElements = {}
	watch.forEach(function(w) {
		watchedElements[w.elemID] = retrieveElementValue(w.elemID, w.from);
	});

	// init listen
	listen
			.forEach(function(entry) {
				entry.event
						.forEach(function(ev) {
							$("*[autoee='" + entry.elemID + "']")
									.on(
											ev.on,
											function() {
												// when activated, send an
												// ajax/jsonp request to
												// retrieve
												// data

												// get watched elements
												var data = {
													"elemID" : entry.elemID,
													"event" : ev.on
												};
												watch
														.forEach(function(w) {
															var v = retrieveElementValue(
																	w.elemID,
																	w.from);
															if (watchedElements[w.elemID] != v) {
																data[w.elemID] = v;
															}
														});

												$
														.ajax({
															"url" : "autoee.json",
															"data" : data,
															"dataType" : ev.dataType,
															"success" : function(
																	data) {
																// data would
																// look like
																/**
																 * {
																 * "state":"success/fail"
																 * [when failed]
																 * ,"err":"error
																 * info" [when
																 * succeeded] ,
																 * "dom":[{"elemID":"",
																 * "method":"html/attr/before/after/empty/remove/removeAttr",
																 * "args":[...]}] }
																 */
																if (data.state == "success") {
																	console
																			.log("success returned")
																	data.dom
																			.forEach(function(
																					e) {
																				if (e.method == "html") {
																					$(
																							"*[autoee='"
																									+ e.elemID
																									+ "'")
																							.html(
																									e.args[0]);
																				} else if (e.method == "attr") {
																					$(
																							"*[autoee='"
																									+ e.elemID
																									+ "'")
																							.attr(
																									e.args[0],
																									e.args[1]);
																				} else if (e.method == "before") {
																					$(
																							"*[autoee='"
																									+ e.elemID
																									+ "'")
																							.before(
																									e.args[0]);
																				} else if (e.method == "after") {
																					$(
																							"*[autoee='"
																									+ e.elemID
																									+ "'")
																							.after(
																									e.args[0]);
																				} else if (e.method == "empty") {
																					$(
																							"*[autoee='"
																									+ e.elemID
																									+ "'")
																							.empty();
																				} else if (e.method == "remove") {
																					$(
																							"*[autoee='"
																									+ e.elemID
																									+ "'")
																							.remove();
																				} else if (e.method == "removeAttr") {
																					$(
																							"*[autoee='"
																									+ e.elemID
																									+ "'")
																							.removeAttr(
																									e.args[0]);
																				}
																			});
																	console
																			.log("succeeded!");
																} else {
																	console
																			.log("failed!");
																	console
																			.log(data.err);
																}
															}
														});
											});
						});
			});
})