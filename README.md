# tweet-cleaner
The program recieves raw Twitter tweet data as input and returns that input with particular elements removed.
The elements to be removed are :
@names, e.g. @donaldjtrump, and any others that are mentioned.
􏰀 URLs.
􏰀 hashtags, e.g. #Hillary, etc..
􏰀 The strings “RT” or ‘rt (RT means ‘retweet’).
􏰀 Any input element that contains digits.
􏰀 Ellipsis (i.e. three/four dots: ...). These appear in the text where a post is split into multiple tweets.
 The tweets example are contained in the file ‘donald.txt’ which contains some tweets by President Donald Trump.
