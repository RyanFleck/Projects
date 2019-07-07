from telegram.ext import Updater, CommandHandler
import random
import logging
import os

# Set debugging level based on environment.
if os.getenv('DYNO'):
    logging.basicConfig(
        format='%(levelname)s - %(message)s',
        level=logging.INFO)
else:
    logging.basicConfig(
        format='%(asctime)s %(levelname)s:  %(name)s - %(message)s',
        level=logging.DEBUG)


def hello(bot, update):
    update.message.reply_text(
        'Hello {}'.format(update.message.from_user.first_name))


def roll(bot, update):
    name = update.message.from_user.first_name
    num = random.randint(0, 21)
    update.message.reply_text('{} rolled a {}'.format(name, num))


# Start the bot.
updater = Updater(os.getenv('JAMES_TELEGRAM'))
updater.dispatcher.add_handler(CommandHandler('hello', hello))
updater.dispatcher.add_handler(CommandHandler('roll', roll))

logging.info('Starting JAMES bot.')
if os.getenv('DYNO'):
    logging.info('Heroku container detected, using WEBHOOKS.')
    updater.start_webhook()
else:
    logging.info('Local env detected, using POLLING.')
    updater.start_polling()
    updater.idle()
