(function($) {

    var defaults = {
        item: {},
        barWidth: 0,
        itemCount: 2,
        itemWidth: 0,
        processWidth: 0,
        curProcessWidth: 0,
        step: 1,
        curStep: 0,
        triggerStep: 1,
        change: false,
        animation: false,
        speed: 1000,
        stepEasingForward: "easeOutCubic",
        stepEasingBackward: "easeOutElastic"
    }

    var $this;
    var flag = true;

    $.fn.stepBarInit = function(option) {
        if (this.length == 0) {
            return;
        }
        $this = this;
        defaults = $.extend(defaults, option);

        layout();
        defaults.item = this.find(".ui-stepInfo");
        if (defaults.item.length < 2) {
            return;
        }
        this.show();
        defaults.itemCount = defaults.item.length;
        defaults.step = !isNaN(defaults.step) && defaults.step <= defaults.itemCount && defaults.step > 0 ? defaults.step : 1;
        defaults.triggerStep = defaults.step;
        if (!isNaN(defaults.speed) && defaults.speed > 0) {
            this.speed = parseInt(defaults.speed);
        }
        stepEasing(defaults.stepEasingForward, false);
        stepEasing(defaults.stepEasingBackward, true);
        stepInfoWidthFun();
    }

    function stepEasing(stepEasing, backward) {
        if (typeof jQuery.easing[stepEasing] === "function") {
            if (backward) {
                defaults.stepEasingBackward = stepEasing;
            } else {
                defaults.stepEasingForward = stepEasing;
            }
        }
    }

    function layout() {
        $this.find(".ui-stepInfo .ui-stepSequence").addClass("judge-stepSequence-hind");
        $this.find(".ui-stepInfo:first-child .ui-stepSequence").addClass("judge-stepSequence-pre");
    }

    function classHover() {
        if (defaults.change) {
            $this.find(".ui-stepInfo .judge-stepSequence-pre").removeClass("judge-stepSequence-hind-change").addClass("judge-stepSequence-pre-change");
            $this.find(".ui-stepInfo .judge-stepSequence-hind").removeClass("judge-stepSequence-pre-change").addClass("judge-stepSequence-hind-change");
        }
    }

    function stepInfoWidthFun() {
        if (defaults.itemCount > 0) {
            defaults.barWidth = $this.width();
            defaults.itemWidth = Math.floor((defaults.barWidth * 0.9) / (defaults.itemCount - 1));
            $this.find(".ui-stepLayout").width(Math.floor(defaults.barWidth * 0.9 + defaults.itemWidth));
            defaults.item.width(defaults.itemWidth);
            $this.find(".ui-stepLayout").css({
                "margin-left": -Math.floor(defaults.itemWidth / 2) + 10
            });
            if (defaults.change) {
                _event();
            }
            percent();
        }
    }

    function _event() {
        $this.on("click", ".ui-stepSequence", function() {
            if (flag) {
                flag = false;
                var triggerStep = $(this).text();
                if (!isNaN(parseInt(triggerStep)) && triggerStep > 0 && triggerStep <= defaults.itemCount && triggerStep != defaults.curStep) {
                    defaults.triggerStep = triggerStep;
                    percent();
                } else {
                    flag = true;
                }
            }
        });
    }

    function percent() {
        var calc = 100 / (defaults.itemCount - 1);
        defaults.processWidth = calc * (defaults.triggerStep - 1) + "%";
        if (defaults.animation) {
            if (defaults.triggerStep < defaults.curStep) {
                _animate();
                defaults.curStep--;
            } else {
                defaults.curStep++;
            }
            defaults.curProcessWidth = calc * (defaults.curStep - 1) + "%";
            $this.find(".ui-stepProcess").stop(true).animate({
                "width": defaults.curProcessWidth
            }, defaults.speed, function() {
                _animate();
                if (defaults.processWidth != defaults.curProcessWidth) {
                    percent();
                } else {
                    flag = true;
                }
            });
        } else {
            if (defaults.curProcessWidth != defaults.processWidth) {
                defaults.curProcessWidth = defaults.processWidth;
                $this.find(".ui-stepProcess").width(defaults.processWidth);
                jump();
            }
            flag = true;
        }
    }

    function jump() {
        $this.find(".ui-stepInfo .ui-stepSequence").removeClass("judge-stepSequence-pre").addClass("judge-stepSequence-hind");
        $this.find(".ui-stepInfo:nth-child(-n+" + defaults.triggerStep + ") .ui-stepSequence").removeClass("judge-stepSequence-hind").addClass("judge-stepSequence-pre");
        classHover();
    }

    function _animate() {
        var stepSequence_size = {},
            easing = defaults.stepEasingBackward,
            preClass,
            hindClass;

        if (defaults.triggerStep < defaults.curStep) {
            stepSequence_size.padding = "6px 10px";
            preClass = "judge-stepSequence-pre";
            hindClass = "judge-stepSequence-hind";
            easing = defaults.stepEasingForward;
        } else {
            stepSequence_size.padding = "8px 12px";
            preClass = "judge-stepSequence-hind";
            hindClass = "judge-stepSequence-pre";
        }
        $this.find(".ui-stepInfo:nth-child(" + defaults.curStep + ") .ui-stepSequence").removeClass(preClass).addClass(hindClass);
        $this.find(".ui-stepInfo:nth-child(" + defaults.curStep + ") .ui-stepSequence").animate(stepSequence_size, 500, easing);
        classHover();
    }



})(jQuery)