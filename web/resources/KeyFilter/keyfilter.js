/*
 * This plugin filters keyboard input by specified regular expression.
 * Version 1.8
 * https://github.com/akzhan/jquery-keyfilter
 *
 * Source code inspired by Ext.JS (Ext.form.TextField, Ext.EventManager)
 *
 * Procedural style:
 * $('#ggg').keyfilter(/[\dA-F]/);
 * Also you can pass test function instead of regexp. Its arguments:
   * this - HTML DOM Element (event target).
   * c - String that contains incoming character.
 * $('#ggg').keyfilter(function(c) { return c != 'a'; });
 *
 * Class style:
 * <input type="text" class="mask-num" />
 *
 * Available classes:
   * mask-pint:     /[\d]/
   * mask-int:      /[\d\-]/
   * mask-pnum:     /[\d\.]/
   * mask-money     /[\d\.\s,]/
   * mask-num:      /[\d\-\.]/
   * mask-hex:      /[0-9a-f]/i
   * mask-email:    /[a-z0-9_\.\-@]/i
   * mask-alpha:    /[a-z_]/i
   * mask-alphanum: /[a-z0-9_]/i
 */

(function($)
{
	// $.browser fallback for jQuery 1.9+.
	if ($.browser === undefined) {
		$.browser = (function () {
			var ua_match = function (ua) {
				ua = ua.toLowerCase();
				var match = /(chrome)[ \/]([\w.]+)/.exec(ua) ||
				/(webkit)[ \/]([\w.]+)/.exec(ua) ||
				/(opera)(?:.*version|)[ \/]([\w.]+)/.exec(ua) ||
				/(msie) ([\w.]+)/.exec(ua) ||
				ua.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec(ua) ||
				[];
				
				return { browser:match[ 1 ] || "", version:match[ 2 ] || "0" };
			},
			matched = ua_match(navigator.userAgent),
			browser = {};
			
			if (matched.browser) {
				browser[ matched.browser ] = true;
				browser.version = matched.version;
			}
			
			if (browser.chrome) {
				browser.webkit = true;
			} else if (browser.webkit) {
				browser.safari = true;
			}
			return browser;
		})();
	}

	var defaultMasks = {
		pint:     /[\d]/,
		'int':    /[\d\-]/,
		pnum:     /[\d\.]/,
		money:    /[\d\.\s,]/,
		num:      /[\d\-\.]/,
		hex:      /[0-9a-f]/i,
		email:    /[a-z0-9_\.\-@]/i,
		alpha:    /[a-z_]/i,
		alphanum: /[a-z0-9_]/i
	};

	var Keys = {
		TAB: 9,
		RETURN: 13,
		ESC: 27,
		BACKSPACE: 8,
		DELETE: 46
	};

	// safari keypress events for special keys return bad keycodes
	var SafariKeys = {
		63234 : 37, // left
		63235 : 39, // right
		63232 : 38, // up
		63233 : 40, // down
		63276 : 33, // page up
		63277 : 34, // page down
		63272 : 46, // delete
		63273 : 36, // home
		63275 : 35  // end
	};

    var isSpecialKey = function(e)
	{
		var k = e.keyCode;
		var c = e.charCode;
		return k == 9 || k == 13 || k == 27 ||
			k == 16 || k == 17 ||
			(k >= 18 && k <= 20) ||
			($.browser.opera && !e.shiftKey && (k == 8 || (k >= 33 && k <= 35) || (k >= 36 && k <= 39) || (k >= 44 && k <= 45)))
			;

        };

        /**
         * Returns a normalized keyCode for the event.
         * @return {Number} The key code
         */
        var getKey = function(e)
	{
		var k = e.keyCode || e.charCode;
		return $.browser.safari ? (SafariKeys[k] || k) : k;
        };

        var getCharCode = function(e)
	{
		return e.charCode || e.keyCode || e.which;
	};

	$.fn.keyfilter = function(re)
	{
		return this.on('keypress',function(e)
		{
			var keyNo = e.which;
			if ($.browser.mozilla && (e.ctrlKey || e.altKey)) // PF GitHub #3785
			{
				return;
			} 
			else if (keyNo == 17 || keyNo == 18) // PF GitHub #1852 keyCode.CONTROL and keyCode.ALT
			{
				return;
			}
			
			var c = getCharCode(e), cc = String.fromCharCode(c), ok = true;
			if(!$.browser.mozilla && (isSpecialKey(e) || !cc))
			{
				return;
			}
			if (typeof re === "function")
			{
				ok = re.call(this, cc);
			}
			else
			{
				ok = re.test(cc);
			}
			if(!ok)
			{
				e.preventDefault();
			}
		});
	};

	$.extend($.fn.keyfilter, {
		defaults: {
			masks: defaultMasks
		},
		version: 1.8
	});

	/* 
	 * This will be manually done by our wrapper
	 *  
	$(document).ready(function()
	{
		var tags = $('input[class*=mask],textarea[class*=mask]');
		for (var key in $.fn.keyfilter.defaults.masks)
		{
			tags.filter('.mask-' + key).keyfilter($.fn.keyfilter.defaults.masks[key]);
		}
	}); */

})(jQuery);;/**
 * __PrimeFaces KeyFilter Widget__
 * 
 * KeyFilter is used to filter keyboard input on specified input components.
 * 
 * @prop {JQuery} target The DOM element for the target input element to which this key filter is applied.
 * 
 * @interface {PrimeFaces.widget.KeyFilterCfg} cfg The configuration for the {@link  KeyFilter| KeyFilter widget}.
 * You can access this configuration via {@link PrimeFaces.widget.BaseWidget.cfg|BaseWidget.cfg}. Please note that this
 * configuration is usually meant to be read-only and should not be modified.
 * @extends {PrimeFaces.widget.BaseWidgetCfg} cfg
 * 
 * @prop {RegExp} cfg.inputRegEx Defines the regular expression which should be used to test the complete input text
 * content. The options `testFunction`, `regEx`, `inputRegEx`, and `mask` are mutually exclusive.
 * @prop {keyof JQueryKeyfilter.DefaultMasks} cfg.mask Defines the predefined mask which should be used. The options
 * `testFunction`, `regEx`, `inputRegEx`, and `mask` are mutually exclusive.
 * @prop {boolean} cfg.preventPaste Whether the component also should prevent paste.
 * @prop {RegExp} cfg.regEx Defines the regular expression which should be used for filtering the input. The options
 * `testFunction`, `regEx`, `inputRegEx`, and `mask` are mutually exclusive.
 * @prop {string} cfg.target The target input expression, defaults to the parent of this component.
 * @prop {JQueryKeyfilter.TestFunction} cfg.testFunction An optional function which should be used for filtering. The
 * options `testFunction`, `regEx`, `inputRegEx`, and `mask` are mutually exclusive.
 */
PrimeFaces.widget.KeyFilter = PrimeFaces.widget.BaseWidget.extend({

    /**
     * @override
     * @inheritdoc
     * @param {PrimeFaces.PartialWidgetCfg<TCfg>} cfg
     */
    init : function(cfg) {
        this._super(cfg);

        this.target = PrimeFaces.expressions.SearchExpressionFacade.resolveComponentsAsSelector(this.cfg.target);

        if (this.target.is(':input')) {
            this.applyKeyFilter(this.target, cfg);
        } else {
            var nestedInput = $(':not(:submit):not(:button):input:visible:enabled:first', this.target);
            this.applyKeyFilter(nestedInput, cfg);
        }
    },

    /**
     * Applies the key filter to the given input or textarea element.
     *
     * @param {JQuery} input A jQuery selector object.
     * @param {TCfg} cfg The widget configuration.
     * @private
     */
    applyKeyFilter : function(input, cfg) {
        if (this.cfg.regEx) {
            input.keyfilter(this.cfg.regEx);
        } else if(this.cfg.inputRegEx) {
            var inputRegEx = this.cfg.inputRegEx;
            var previousInputValue = '';
            input.on('input', function(e) {
                    var ok = inputRegEx.test(this.value);
                    if(ok) {
                            previousInputValue = this.value;
                    }
                    else {
                            this.value = previousInputValue;
                    }
            });
        } else if (this.cfg.testFunction) {
            input.keyfilter(this.cfg.testFunction);
        } else if (this.cfg.mask) {
            input.keyfilter($.fn.keyfilter.defaults.masks[this.cfg.mask]);
        }
        
        //disable drop
        input.on('drop', function(e) {
            e.preventDefault();
        });

        if (cfg.preventPaste) {
            //disable paste
            input.on('paste', function(e) {
                e.preventDefault();
            });
        }
    }
});
