import com.fasterxml.jackson.databind.JsonNode;

public class Tweet {
    public String id;
    public String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFavorites_count() {
        return favorites_count;
    }

    public void setFavorites_count(int favorites_count) {
        this.favorites_count = favorites_count;
    }

    public int getRetweet_count() {
        return retweet_count;
    }

    public void setRetweet_count(int retweet_count) {
        this.retweet_count = retweet_count;
    }

    public int getQuote_count() {
        return quote_count;
    }

    public void setQuote_count(int quote_count) {
        this.quote_count = quote_count;
    }

    public int getReply_count() {
        return reply_count;
    }

    public void setReply_count(int reply_count) {
        this.reply_count = reply_count;
    }

    // private User user;
    // private Entities entities;
    public int favorites_count;
    public int retweet_count;
    public int quote_count;
    public int reply_count;

    public Tweet(JsonNode node) {
        extractData(node);
    }

    private void extractData(JsonNode node) {
        id = node.get("id").asText();
        text = node.get("text").asText();
        //favorites_count = node.get("favourites_count").asInt();
        retweet_count = node.get("retweet_count").asInt();
        quote_count = node.get("quote_count").asInt();
        reply_count = node.get("reply_count").asInt();
    }
}
