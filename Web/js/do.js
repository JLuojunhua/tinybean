! function() {
	var t, e, n = document,
		r = window,
		i = window.__external_files_loaded = window.__external_files_loaded || {},
		o = window.__external_files_loading = window.__external_files_loading || {},
		a = function(t) {
			return t.constructor === Array
		},
		s = {
			autoLoad: !0,
			coreLib: ["//img3.doubanio.com/js/jquery.min.js"],
			mods: {}
		},
		c = n.getElementsByTagName("script"),
		d = c[c.length - 1],
		u = [],
		l = !1,
		f = [],
		h = function(t, e, r, a, s) {
			var d = c[0];
			if(t) {
				if(i[t]) return o[t] = !1, void(a && a(t, s));
				if(o[t]) return void setTimeout(function() {
					h(t, e, r, a, s)
				}, 1);
				o[t] = !0;
				var u, l = e || t.toLowerCase().split(/\./).pop().replace(/[\?#].*/, "");
				if("js" === l ? (u = n.createElement("script"), u.setAttribute("type", "text/javascript"), u.setAttribute("src", t), u.setAttribute("async", !0)) : "css" === l && (u = n.createElement("link"), u.setAttribute("type", "text/css"), u.setAttribute("rel", "stylesheet"), u.setAttribute("href", t), i[t] = !0), u) {
					if(r && (u.charset = r), "css" === l) return d.parentNode.insertBefore(u, d), void(a && a(t, s));
					u.onload = u.onreadystatechange = function() {
						this.readyState && "loaded" !== this.readyState && "complete" !== this.readyState || (i[this.getAttribute("src")] = !0, a && a(this.getAttribute("src"), s), u.onload = u.onreadystatechange = null)
					}, d.parentNode.insertBefore(u, d)
				}
			}
		},
		p = function(t) {
			if(t && a(t)) {
				for(var e, n = 0, r = [], i = s.mods, o = [], c = {}, d = function(t) {
						var e, n, r = 0;
						if(c[t]) return o;
						if(c[t] = !0, i[t].requires) {
							for(n = i[t].requires;
								"undefined" != typeof(e = n[r++]);) i[e] ? (d(e), o.push(e)) : o.push(e);
							return o
						}
						return o
					};
					"undefined" != typeof(e = t[n++]);) i[e] && i[e].requires && i[e].requires[0] && (o = [], c = {}, r = r.concat(d(e))), r.push(e);
				return r
			}
		},
		y = function() {
			l = !0, u.length > 0 && (e.apply(this, u), u = [])
		},
		m = function() {
			n.addEventListener ? n.removeEventListener("DOMContentLoaded", m, !1) : n.attachEvent && n.detachEvent("onreadystatechange", m), y()
		},
		v = function() {
			if(!l) {
				try {
					n.documentElement.doScroll("left")
				} catch(t) {
					return r.setTimeout(v, 1)
				}
				y()
			}
		},
		g = function() {
			if("complete" === n.readyState) return r.setTimeout(y, 1);
			var t = !1;
			if(n.addEventListener) n.addEventListener("DOMContentLoaded", m, !1), r.addEventListener("load", y, !1);
			else if(n.attachEvent) {
				n.attachEvent("onreadystatechange", m), r.attachEvent("onload", y);
				try {
					t = null === r.frameElement
				} catch(t) {}
				document.documentElement.doScroll && t && v()
			}
		},
		E = function(t) {
			t && a(t) && (this.queue = t, this.current = null)
		};
	E.prototype = {
		_interval: 10,
		start: function() {
			return this.current = this.next(), this.current ? void this.run() : void(this.end = !0)
		},
		run: function() {
			var t, e = this,
				n = this.current;
			return "function" == typeof n ? (n(), void this.start()) : void("string" == typeof n && (s.mods[n] ? (t = s.mods[n], h(t.path, t.type, t.charset, function(t) {
				e.start()
			}, e)) : /\.js|\.css/i.test(n) ? h(n, "", "", function(t, e) {
				e.start()
			}, e) : this.start()))
		},
		next: function() {
			return this.queue.shift()
		}
	}, t = d.getAttribute("data-cfg-autoload"), "string" == typeof t && (s.autoLoad = "true" === t.toLowerCase()), t = d.getAttribute("data-cfg-corelib"), "string" == typeof t && (s.coreLib = t.split(",")), e = function() {
		var t, e = [].slice.call(arguments);
		f.length > 0 && (e = f.concat(e)), s.autoLoad && (e = s.coreLib.concat(e)), t = new E(p(e)), t.start()
	}, e.add = function(t, e) {
		t && e && e.path && (s.mods[t] = e)
	}, e.delay = function() {
		var t = [].slice.call(arguments),
			n = t.shift();
		r.setTimeout(function() {
			e.apply(this, t)
		}, n)
	}, e.global = function() {
		var t = [].slice.call(arguments);
		f = f.concat(t)
	}, e.ready = function() {
		var t = [].slice.call(arguments);
		return l ? e.apply(this, t) : void(u = u.concat(t))
	}, e.css = function(t) {
		var e = n.getElementById("do-inline-css");
		e || (e = n.createElement("style"), e.type = "text/css", e.id = "do-inline-css", n.getElementsByTagName("head")[0].appendChild(e)), e.styleSheet ? e.styleSheet.cssText = e.styleSheet.cssText + t : e.appendChild(n.createTextNode(t))
	}, s.autoLoad && e(s.coreLib), e.define = e.add, e._config = s, e._mods = s.mods, this.Do = e, g()
}();