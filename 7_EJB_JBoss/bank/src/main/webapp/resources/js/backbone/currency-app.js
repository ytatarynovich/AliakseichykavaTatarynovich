
var Currency = Backbone.Model.extend({
	name: '',
	rate: '',

	initialize: function(arg){
		console.log('Fetched: ' + arg);
		this.name = arg.name;
		this.rate = arg.rate;
	},
});

var CurrencyCollection = Backbone.Collection.extend({
	model : Currency,
	url: '/BankApp/currency/getall'
});

var currencies = new CurrencyCollection();


var CurrencyView = Backbone.View.extend({
	tagName: "li",

	initialize: function() {
		this.model.view = this;
	},

	render : function() {
		$(this.el).text(this.model.name + ': ' + this.model.rate);
		return this;
	}
});


 window.AppView = Backbone.View.extend({
	el: $("#todoapp"),

	addOne: function(currency) {
		console.log('Add currency: ' + currency);
		var view = new CurrencyView({model: currency});
		this.$("#todo-list").append(view.render().el);
	},

	addAll: function() {
		console.log('Add all currencies');
		currencies.each(this.addOne);
	},

	render: function() {
		//
	},

	initialize: function() {
		console.log('init app');

		_.bindAll(this, 'addOne', 'addAll', 'render');

		currencies.bind('add', this.addOne);
		currencies.bind('refresh', this.addAll);
		currencies.bind('all', this.render);

		currencies.fetch();
	}

});

 window.App = new AppView();