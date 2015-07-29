$(function () {
    // get the GET variables
    var theme = getUrlVars();

    //show the active theme in the top level
    if(theme['theme']) {
        $('#theme_current').html($('#'+theme['theme']).html());
        $('#preview-frame').attr('src', 'http://themes.vivantdesigns.com/' + theme['theme'] );

        //Demo Link
        var demoLink = 'http://themes.vivantdesigns.com/' + $('#' + theme['theme']).attr('id');

        //Purchase Link
        var purchaseLink = $('#' + theme['theme']).attr('data-purchase-link');

        $('#close').attr('href', demoLink);
        $('#purchase_download').attr('href', purchaseLink);
    }

    $("#theme_dropdown ul ul li a").click(function(){
        //Demo Link
        var demoLink = 'http://themes.vivantdesigns.com/' + $(this).attr('id');

        //Purchase Link
        var purchaseLink = $(this).attr('data-purchase-link');

        //Theme name
        var themeName = $(this).attr('id');

        $('#theme_current').html($('#'+themeName).html());
        $('#close').attr('href', demoLink);
        $('#purchase_download').attr('href', purchaseLink);
        $('#preview-frame').attr('src', 'http://themes.vivantdesigns.com/' + themeName);
    });

    //toggle dropdown list
    $('.dropdowns').toggle(
        function () {
            $('> li > ul', this).animate({opacity: 1}, 100).show();
        }, function() {
            $('> li > ul', this).animate({opacity: 0}, 300).hide();
        }
    );
    
    $('[rel=popover]').popover();
    $('[rel=twipsy]').tooltip();

    // Read a page's GET URL variables and return them as an associative array.
    function getUrlVars()
    {
        var vars = [], hash;
        var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');

        for(var i = 0; i < hashes.length; i++)
        {
            hash = hashes[i].split('=');
            vars.push(hash[0]);
            vars[hash[0]] = hash[1];
        }

        return vars;
    }
});
